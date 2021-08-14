package fr.zeykra.bdb.commands.subcommands;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.commands.SubCommand;
import fr.zeykra.bdb.core.PlayerCapture;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.entity.Player;

public class SubCommandStop extends SubCommand {
    @Override
    public String getName() {
        return "stop";
    }

    @Override
    public String getDescription() {
        return "Arette l'event de bdb en cours";
    }

    @Override
    public String getSyntax() {
        return "/bdb stop";
    }

    YmlFileUtil lang = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "lang.yml");
    YmlFileUtil config = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "config.yml");

    @Override
    public void perform(Player player, String[] args) {
        player.getServer().broadcastMessage(lang.getString("bdb-stop-broadcast"));
        PlayerCapture.stopCaptureRunnable();
    }
}
