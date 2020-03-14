package net.mythiccraft.core.gui;

import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Represents an item that can be clicked.
 */
public interface Clickable {

    /**
     * Called when the item is clicked
     *
     * @param e The click event
     */
    void onClick(InventoryClickEvent e);
}
