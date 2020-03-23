package net.mythiccraft.core.util;

import org.bukkit.inventory.Inventory;

/**
 * @author Taylor Hughes
 */
public abstract class Menu {

    private String name;
    private Menu parent;

    public Menu(String name) {
        this.name = name;
        this.parent = this;
    }

    public Menu(String name, Menu parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public abstract Inventory getInventory();
}
