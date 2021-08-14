package fr.zeykra.bdb;

import com.sun.scenario.Settings;
import fr.zeykra.bdb.commands.CommandManager;
import fr.zeykra.bdb.enums.FileEnum;
import fr.zeykra.bdb.event.CraftEvent;
import fr.zeykra.bdb.core.PlayerCapture;
import fr.zeykra.bdb.event.PlayerJoinEvent;
import fr.zeykra.bdb.event.WandEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class BDB extends JavaPlugin {
    private Settings settings;
    private static BDB instance;

    @Override
    public void onEnable() {

        //register de la commande
        this.getCommand("bdb").setExecutor(new CommandManager());

        //register des event
        getServer().getPluginManager().registerEvents(new CraftEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerCapture(), this);
        getServer().getPluginManager().registerEvents(new WandEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);

        instance = this;

        //Création des fichier config / lang
        FileEnum config = FileEnum.CONFIG;
        config.create(getLogger());
        FileEnum lang = FileEnum.LANG;
        lang.create(getLogger());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BDB getInstance() {
        return instance;
    }
}
