package fr.zeykra.bdb.event;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.core.Item;
import fr.zeykra.bdb.lang.LangValues;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CraftEvent implements Listener {

    static BDB instance = BDB.getPlugin(BDB.class);
    static YmlFileUtil lang = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "lang.yml");

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

    public static void tryAutocraft(Player player, ItemStack recipeItem, ItemStack resultItem) {

        int n = 0;
        PlayerInventory inv = player.getInventory();
        for (ItemStack is : inv.all(recipeItem.getType()).values()) {
            if (is != null && is.getType() == recipeItem.getType()) {
                if(is.getItemMeta().getDisplayName().equalsIgnoreCase(recipeItem.getItemMeta().getDisplayName())) {
                    n = n + is.getAmount();
                }
            }
            if(n >= 9) {
                for(int i = 0 ; i < 9; i++) {
                    player.getInventory().removeItem(recipeItem);
                }
                String message = LangValues.customFormat(lang.getString("autocraft-message"), "{RECIPEITEM}", recipeItem.getItemMeta().getDisplayName() + "§r");
                player.sendMessage(LangValues.customFormat(message, "{RESULTITEM}", resultItem.getItemMeta().getDisplayName() + "§r"));
                inv.addItem(resultItem);
                player.updateInventory();
            }
        }
    }
}
