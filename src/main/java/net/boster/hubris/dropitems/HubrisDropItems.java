package net.boster.hubris.dropitems;

import lombok.Getter;
import net.boster.hubris.dropitems.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HubrisDropItems extends JavaPlugin {

    @Getter private static HubrisDropItems instance;

    @Getter private final List<DroppedItem> droppedItems = new ArrayList<>();

    public HubrisDropItems() {
        instance = this;
    }

    public void onEnable() {
        String PREFIX = "\u00a76+\u00a7a---------------- \u00a7dBosterSkills \u00a7a------------------\u00a76+";
        Bukkit.getConsoleSender().sendMessage(PREFIX);

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        startTask();
        Bukkit.getConsoleSender().sendMessage("\u00a7d[\u00a7bBosterSkills\u00a7d] \u00a7fThe plugin has been \u00a7dEnabled\u00a7f!");
        Bukkit.getConsoleSender().sendMessage("\u00a7d[\u00a7bBosterSkills\u00a7d] \u00a7fPlugin creator: \u00a7dBosternike");
        Bukkit.getConsoleSender().sendMessage("\u00a7d[\u00a7bBosterSkills\u00a7d] \u00a7fPlugin version: \u00a7d" + getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(PREFIX);
    }

    public DroppedItem getByDroppedItem(@NotNull Item item) {
        for(DroppedItem i : droppedItems) {
            if(i.getItem().getUniqueId().equals(item.getUniqueId())) return i;
        }

        return null;
    }

    private void startTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                droppedItems.removeIf(d -> !d.getItem().isValid() || d.getTime() - System.currentTimeMillis() >= 0);
            }
        }.runTaskTimer(this, 0, 0);
    }
}
