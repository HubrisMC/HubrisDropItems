package net.boster.hubris.dropitems;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
@Getter
public class DroppedItem {

    @NotNull private final Player player;
    @NotNull private final Item item;
    private final long time;
}
