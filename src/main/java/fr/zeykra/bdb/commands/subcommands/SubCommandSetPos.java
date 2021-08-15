package fr.zeykra.bdb.commands.subcommands;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.commands.SubCommand;
import fr.zeykra.bdb.enums.FileEnum;
import fr.zeykra.bdb.lang.LangValues;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SubCommandSetPos extends SubCommand {
    @Override
    public String getName() {
        return "setpos";
    }

    @Override
    public String getDescription() {
        return "Permet de definir la positions des coins";
    }

    @Override
    public String getSyntax() {
        return "/bdb setpos [1/2]";
    }

    BDB instance = BDB.getPlugin(BDB.class);
    YmlFileUtil config = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "/config.yml");
    YmlFileUtil lang = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "/lang.yml");

    @Override
    public void perform(Player player, String[] args) {
        if(args.length > 1) {
            if(args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("2")) {
                config.setConfigSection("pos" + args[1]);
                Location loc = new Location(player.getWorld(), player.getLocation().getBlockX() + .5,
                        player.getLocation().getBlockY() + .5, player.getLocation().getBlockZ() + .5
                );
                config.setLoc(loc);
                player.sendMessage(LangValues.format(lang.getString("setpos" + args[1] + "-message"), loc));
            }
        } else if(args.length == 1){
            player.sendMessage(lang.getString("error-setpos"));
        }

    }
}
