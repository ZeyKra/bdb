package fr.zeykra.bdb.core;

import fr.zeykra.bdb.BDB;
import fr.zeykra.bdb.util.ColorUtil;
import fr.zeykra.bdb.util.YmlFileUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Item {

    //Class Contenant les items utilisé dans le plugin

    static BDB instance = BDB.getPlugin(BDB.class);
    static YmlFileUtil lang = new YmlFileUtil(instance.getDataFolder().toPath().toString(), "/lang.yml");

    public static ItemStack goldIngot() {
        ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ColorUtil.format(lang.getString("gold-ingot-name")));
        item.setItemMeta(im);
        return item;
    }

    public static ItemStack goldNugget() {
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ColorUtil.format(lang.getString("gold-nugget-name")));
        item.setItemMeta(im);
        return item;
    }

    public static ItemStack mycelium() {
        ItemStack item = new ItemStack(Material.MYCEL, 1);

        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ColorUtil.format(lang.getString("mycelium-name")));
        im.addEnchant(Enchantment.KNOCKBACK, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        return item;
    }

    public static ItemStack Wand() {
        ItemStack item = new ItemStack(Material.STONE_AXE, 1);

        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ColorUtil.format(lang.getString("wand-name")));
        im.setLore(Arrays.asList("", "§ePos1: §7Aucune", "§ePos2: §7Aucune"));
        item.setItemMeta(im);
        return item;
    }

}
