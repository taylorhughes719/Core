package net.mythiccraft.core.kit;

import net.mythiccraft.core.gui.GUIHolder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * The kits gui on /kits
 */
public class KitsMenu implements GUIHolder {

    private Player player;
    private Inventory inventory;

    public KitsMenu(Player player) {
        this.player = player;
    }

    /**
     * Get the object's inventory.
     *
     * @return The inventory.
     */
    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return this.player;
    }
}
