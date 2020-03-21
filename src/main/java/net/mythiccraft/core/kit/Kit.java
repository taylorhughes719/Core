package net.mythiccraft.core.kit;

import net.mythiccraft.core.Core;
import net.mythiccraft.core.config.KitConfig;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A kit class.
 */
public class Kit {

    private String name;
    private long interval;
    private ItemStack helmet, chestplate, leggings, boots;
    private ItemStack[] contents;
    private KitConfig config;
    private boolean defaultKit;

    public Kit(String name, boolean defaultKit) {
        this.name = name;
        this.interval = 0L;
        this.defaultKit = defaultKit;
        this.config = new KitConfig(Core.getInstance(), name, defaultKit);
    }

    public boolean isDefaultKit() {
        return defaultKit;
    }

    public KitConfig getConfig() {
        return config;
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

    public ItemStack[] getContents() {
        return contents;
    }

    public void setContents(ItemStack[] contents) {
        this.contents = contents;
    }

    public void setContents(List<ItemStack> contents) {
        this.contents = (ItemStack[]) contents.toArray();
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

    public void give(Player player) {
        if (player.getInventory().getHelmet() == null || player.getInventory().getHelmet().getType() == Material.AIR) {
            player.getInventory().setHelmet(getHelmet());
        } else {
            player.getInventory().setItem(player.getInventory().firstEmpty(), getHelmet());
        }

        if (player.getInventory().getChestplate() == null || player.getInventory().getChestplate().getType() == Material.AIR) {
            player.getInventory().setChestplate(getChestplate());
        } else {
            player.getInventory().setItem(player.getInventory().firstEmpty(), getChestplate());
        }

        if (player.getInventory().getLeggings() == null || player.getInventory().getLeggings().getType() == Material.AIR) {
            player.getInventory().setLeggings(getLeggings());
        } else {
            player.getInventory().setItem(player.getInventory().firstEmpty(), getLeggings());
        }

        if (player.getInventory().getBoots() == null || player.getInventory().getBoots().getType() == Material.AIR) {
            player.getInventory().setBoots(getBoots());
        } else {
            player.getInventory().setItem(player.getInventory().firstEmpty(), getBoots());
        }


    }
}
