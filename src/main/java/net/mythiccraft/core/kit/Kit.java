package net.mythiccraft.core.kit;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * A kit class.
 */
public class Kit {

    private String name;
    private long interval;
    private ItemStack helmet, chestplate, leggings, boots;
    private Map<Integer, ItemStack> items;

    public Kit(String name) {
        this.name = name;
        this.items = new HashMap<>();
        this.interval = 0L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return "core.kits." + name;
    }

    public long getInterval() {
        return interval;
    }

    public Map<Integer, ItemStack> getItems() {
        return items;
    }

    public ItemStack getBoots() {
        return boots;
    }

    public void setBoots(ItemStack boots) {
        this.boots = boots;
    }

    public ItemStack getChestplate() {
        return chestplate;
    }

    public void setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public void setLeggings(ItemStack leggings) {
        this.leggings = leggings;
    }

    public ItemStack getHelmet() {
        return helmet;
    }

    public void setHelmet(ItemStack helmet) {
        this.helmet = helmet;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}
