package fr.zeykra.bdb.core;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.core.Item;
import fr.zeykra.bdb.util.Cuboid;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class PlayerCapture implements Listener {

    static BDB instance = BDB.getPlugin(BDB.class);

    //Hashmap contenant le temps de capture de chaque cappers, permet aussi de detecter qui cap
    private static HashMap<UUID, Double> playersCaptureTime = new HashMap<>();
    private static Integer taskId; // id de la runnable pour la stop

    static YmlFileUtil lang = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "lang.yml");
    static YmlFileUtil config = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "config.yml");

    Cuboid BDBCube = new Cuboid(config.getLoc("pos1"), config.getLoc("pos2"));

    //Début la runnable qui donne les récompenses au cappers
    public static void startCaptureRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                taskId = this.getTaskId();
                for (Map.Entry<UUID, Double> e : playersCaptureTime.entrySet()) {
                    UUID uuid = e.getKey();
                    Player player = Bukkit.getPlayer(uuid);
                    playersCaptureTime.put(uuid, playersCaptureTime.get(uuid) + 0.1);
                    if(playersCaptureTime.get(uuid) >= 5) {
                        captureSucessPlayer(player);
                    }
                }
            }
        }.runTaskTimerAsynchronously(instance, 0, 2);
        config.set("started", true);
    }

    //Fonction pour stopper la runnable
    public static void stopCaptureRunnable() {
        Bukkit.getScheduler().cancelTask(taskId);
        YmlFileUtil yconfig = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "config.yml");
        yconfig.set("started", false);
    }

    //Fonction quand le joueur commence a capturer
    public void startPlayerCapture(Player player) {
        playersCaptureTime.putIfAbsent(player.getUniqueId(), 0.0);
        player.sendMessage(lang.getString("player-startcapture-message"));
    }

    //Fonction quand le joueur quitte la capture
    public void quitPlayerCapture(Player player) {
        playersCaptureTime.remove(player.getUniqueId());
        player.sendMessage(lang.getString("player-quitcapture-message"));
    }

    //Fonction quand le joueur réussit cap pendant x temps
    private static void captureSucessPlayer(Player player) {
        playersCaptureTime.put(player.getUniqueId(), 0.0);
        player.getInventory().addItem(Item.goldNugget());
        player.sendMessage(lang.getString("player-sucesscapture-message"));
    }

    //Quand le joeur rentre dans le bdb
    @EventHandler
    public void playerWalkEvent(PlayerMoveEvent e){
        Player player = e.getPlayer();
        config = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "config.yml");
        if(config.getBoolean("started") == true) {
            if(BDBCube.contains(player.getLocation())) {
                if(playersCaptureTime.get(player.getUniqueId()) == null) { startPlayerCapture(player); }
            } else {
                if(playersCaptureTime.get(player.getUniqueId()) != null) { quitPlayerCapture(player);}
            }
        }

    }


}
