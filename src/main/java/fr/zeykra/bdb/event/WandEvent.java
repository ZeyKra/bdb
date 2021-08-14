package fr.zeykra.bdb.event;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.core.Item;
import fr.zeykra.bdb.lang.LangValues;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WandEvent implements Listener {

    YmlFileUtil config = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "config.yml");
    YmlFileUtil lang = new YmlFileUtil(BDB.getPlugin(BDB.class).getDataFolder().toPath().toString(), "lang.yml");

    //La class avec toutes les fonctionnalité de la hache de selection

    @EventHandler
    public void onInterract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();
        if(item == null || !item.hasItemMeta() || item.getType() != Material.STONE_AXE) { return; }

        ItemMeta im = item.getItemMeta();
        if(im.hasDisplayName() && im.getDisplayName().equalsIgnoreCase(Item.Wand().getItemMeta().getDisplayName())) {
            if(!player.hasPermission("bdb.admin")) { return; }
            ItemMeta newIm = item.getItemMeta();
            Location blockLoc = e.getClickedBlock().getLocation();
            List<String> newLore = new ArrayList<>();
            for(String line : newIm.getLore()) {
                String newLine = line;
                if(action.equals(Action.LEFT_CLICK_BLOCK)) { //pour changer le lore de la hache avec la pos1 et la definir
                    e.setCancelled(true);
                    if (newLine.contains("Pos1")) {
                        newLine = LangValues.format(lang.getString("pos1-lore"), blockLoc);
                        config.setLoc("pos1", blockLoc);
                        player.sendMessage(LangValues.format(lang.getString("setpos1-message"), blockLoc));
                    }
                }
                if(action.equals(Action.RIGHT_CLICK_BLOCK)) { //pour changer le lore de la hache avec la pos1 et la definir
                    if (newLine.contains("Pos2")) {
                        newLine = LangValues.format(lang.getString("pos2-lore"), blockLoc);
                        config.setLoc("pos2", blockLoc);
                        player.sendMessage(LangValues.format(lang.getString("setpos2-message"), blockLoc));
                    }
                }
                newLore.add(newLine);
            }
            newIm.setLore(newLore);
            item.setItemMeta(newIm);

        }

    }

}
