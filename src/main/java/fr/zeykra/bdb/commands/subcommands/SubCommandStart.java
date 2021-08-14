package fr.zeykra.bdb.commands.subcommands;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.commands.SubCommand;
import fr.zeykra.bdb.core.PlayerCapture;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.entity.Player;

public class SubCommandStart extends SubCommand { // /prank freeze

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String getDescription() {
        return "Demarrer l'event de bdb";
    }

    @Override
    public String getSyntax() {
        return "/bdb start";
    }

    YmlFileUtil lang = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "lang.yml");
    YmlFileUtil config = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "config.yml");

    @Override
    public void perform(Player player, String[] args) {

        PlayerCapture.startCaptureRunnable();
        player.getServer().broadcastMessage(lang.getString("bdb-start-broadcast"));

    }
}