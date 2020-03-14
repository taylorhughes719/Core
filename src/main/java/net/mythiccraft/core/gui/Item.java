package net.mythiccraft.core.gui;

import org.bukkit.inventory.ItemStack;

/**
 * Represents a GUI item
 */
public abstract class Item implements Clickable {

    private ItemStack item;

    public Item(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
}
