package net.boster.hubris.dropitems.listeners;

import lombok.RequiredArgsConstructor;
import net.boster.hubris.dropitems.DroppedItem;
import net.boster.hubris.dropitems.HubrisDropItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class PlayerListener implements Listener {

    @NotNull private final HubrisDropItems plugin;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPickup(EntityPickupItemEvent e) {
        DroppedItem i = plugin.getByDroppedItem(e.getItem());
        if(i == null) return;
        if(e.getEntity() instanceof Player p && i.getPlayer() == p) return;

        e.setCancelled(true);
    }
}
