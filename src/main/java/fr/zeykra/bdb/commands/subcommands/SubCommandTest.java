package fr.zeykra.bdb.commands.subcommands;

import fr.zeykra.bdb.commands.SubCommand;
import fr.zeykra.bdb.core.Item;
import org.bukkit.entity.Player;

public class SubCommandTest extends SubCommand {
    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "commande de test";
    }

    @Override
    public String getSyntax() {
        return "/bdb test";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args[1].equalsIgnoreCase("items")) {
            player.getInventory().addItem(Item.mycelium());
            player.getInventory().addItem(Item.goldNugget());
            player.getInventory().addItem(Item.goldIngot());
        }
    }
}
