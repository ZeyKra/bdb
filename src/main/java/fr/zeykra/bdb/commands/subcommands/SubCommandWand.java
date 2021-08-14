package fr.zeykra.bdb.commands.subcommands;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.commands.SubCommand;
import fr.zeykra.bdb.core.Item;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.entity.Player;

public class SubCommandWand extends SubCommand {
    @Override
    public String getName() {
        return "wand";
    }

    @Override
    public String getDescription() {
        return "recevoir l'outil de selection";
    }

    @Override
    public String getSyntax() {
        return "/bdb wand";
    }


    YmlFileUtil lang = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "lang.yml");
    @Override
    public void perform(Player player, String[] args) {
        player.getInventory().addItem(Item.Wand());
        player.sendMessage(lang.getString("wand-recieved"));
    }
}
