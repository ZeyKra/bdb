package fr.zeykra.bdb.event;

import fr.zeykra.bdb.core.Item;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftEvent implements Listener {

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        int goldNuggets = 0;
        int goldIngots = 0;
        /*
        * Fonctionnement: ça loop la table de craft, si le nombre de pépite d'or est égale a 9
        * c'est a dire la table entièrement remplie. Le lingot est mit dans la table de craft -> resultat
        * Le meme système est utilisé pour le mycélium
        * */
        for(ItemStack item : e.getInventory().getContents()) {
            //Craft du lingot d'or
            if(item.getType() == Material.GOLD_NUGGET && item.hasItemMeta()) {
                if(item.getItemMeta().getDisplayName().equalsIgnoreCase(Item.goldNugget().getItemMeta().getDisplayName())) {
                    goldNuggets++;
                }
            }
            //Craft du mycelium
            if(item.getType() == Material.GOLD_INGOT && item.hasItemMeta()) {
                if(item.getItemMeta().getDisplayName().equalsIgnoreCase(Item.goldIngot().getItemMeta().getDisplayName())) {
                    goldIngots++;
                }
            }
        }
        if(goldNuggets == 9) { e.getInventory().setResult(Item.goldIngot()); }
        if(goldIngots == 9) { e.getInventory().setResult(Item.mycelium()); }

    }
}
