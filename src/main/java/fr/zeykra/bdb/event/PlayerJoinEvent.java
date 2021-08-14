package fr.zeykra.bdb.event;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.core.PlayerCapture;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinEvent implements Listener {

    //Auto start

    YmlFileUtil config;
    YmlFileUtil lang = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "lang.yml");

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player player = e.getPlayer(); // si le nombre de joueur est suffisant
        config = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "config.yml");
        if(config.getBoolean("autostart") == true && config.getBoolean("started") == false) {
            if(player.getServer().getOnlinePlayers().size() >= config.getInt("autostart-number")) {
                PlayerCapture.startCaptureRunnable();
                player.getServer().broadcastMessage(lang.getString("bdb-autostart-start"));
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e .getPlayer(); // si le nombre de joueur est insuffisant
        System.out.println(Bukkit.getServer().getOnlinePlayers().size() );
        config = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "config.yml");
        if(config.getBoolean("autostart") == true && config.getBoolean("started") == true) {
             if ((Bukkit.getServer().getOnlinePlayers().size() - 1) < config.getInt("autostart-number")) {
                Bukkit.getServer().broadcastMessage(lang.getString("bdb-autostart-stop"));
                PlayerCapture.stopCaptureRunnable();

             }
        }
    }

}
