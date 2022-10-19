package net.boster.hubris.dropitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;

public class DropItem {

    public static void drop(@NotNull Location location, @NotNull ItemStack item, @NotNull Player player, long time, @Nullable String customName) {
        Item i = location.getWorld().dropItemNaturally(location, item);
        if(customName != null) {
            i.setCustomName(customName);
        }
        i.setCustomNameVisible(customName != null);
        HubrisDropItems.getInstance().getDroppedItems().add(new DroppedItem(player, i, time));
    }

    public static void drop(@NotNull Location location, @NotNull ItemStack item, @NotNull Player player, @Nullable String customName) {
        drop(location, item, player, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10), customName);
    }

    public static void drop(@NotNull Location location, @NotNull ItemStack item, @NotNull Player player) {
        drop(location, item, player, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10),
                ChatColor.translateAlternateColorCodes('&', "&e") + player.getName());
    }
}
