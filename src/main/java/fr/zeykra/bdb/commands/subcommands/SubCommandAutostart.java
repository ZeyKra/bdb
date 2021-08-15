package fr.zeykra.bdb.commands.subcommands;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.commands.SubCommand;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.entity.Player;

public class SubCommandAutostart extends SubCommand {
    @Override
    public String getName() { return "autostart"; }

    @Override
    public String getDescription() { return "définir le statut de l'autostart"; }

    @Override
    public String getSyntax() { return "/bdb autostart [true/false]"; }


    BDB instance = BDB.getPlugin(BDB.class);
    YmlFileUtil config = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "config.yml");
    YmlFileUtil lang = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "lang.yml");


    @Override
    public void perform(Player player, String[] args) {
        if(args.length > 1) {
            config.set("autostart", Boolean.parseBoolean(args[1].toLowerCase()));
            player.sendMessage(lang.getString("autostart-" + args[1] + "-message"));
        } else if (args.length == 1) {
            player.sendMessage(lang.getString("error-autostart"));
        }
    }
}
