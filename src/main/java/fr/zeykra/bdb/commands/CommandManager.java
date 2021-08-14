package fr.zeykra.bdb.commands;

import fr.zeykra.bdb.commands.subcommands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    //Class permettant de gerer les sous-commands/ arguments de celle si

    private ArrayList<SubCommand> subCommands = new ArrayList<>();

    public CommandManager() {
        subCommands.add(new SubCommandSetPos());
        subCommands.add(new SubCommandStart());
        //subCommands.add(new SubCommandTest()); Commande de test
        subCommands.add(new SubCommandWand());
        subCommands.add(new SubCommandStop());
        subCommands.add(new SubCommandAutostart());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length > 0){
                for (int i = 0; i < getSubcommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).perform(p, args);
                    }
                }
            }else if(args.length == 0){
                p.sendMessage("--------------------------------");
                for (int i = 0; i < getSubcommands().size(); i++){
                    p.sendMessage(getSubcommands().get(i).getSyntax() + " - " + getSubcommands().get(i).getDescription());
                }
                p.sendMessage("--------------------------------");
            }

        }


        return true;
    }

    public ArrayList<SubCommand> getSubcommands(){
        return subCommands;
    }


    public ArrayList<SubCommand> getSubCommands() { return subCommands; }
}
