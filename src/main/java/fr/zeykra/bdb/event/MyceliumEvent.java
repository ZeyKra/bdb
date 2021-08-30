package fr.zeykra.bdb.event;

import fr.zeykra.bdb.core.Item;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MyceliumEvent implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(!e.getItemInHand().hasItemMeta() || e.getBlock().getType() != Material.MYCEL) { return; }
        if(e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Item.mycelium().getItemMeta().getDisplayName())) {
            e.setCancelled(true);
        }
    }
}
