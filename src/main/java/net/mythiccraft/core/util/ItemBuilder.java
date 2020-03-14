package net.mythiccraft.core.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;
    private List<String> lore;

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    public ItemBuilder(Material material, int amount) {
        this(material, null, amount);
    }

    public ItemBuilder(Material material, String name, int amount) {
        this.item = new ItemStack(material, amount);
        this.meta = this.item.hasItemMeta() ? this.item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(this.item.getType());
        assert this.meta != null;
        if (name != null) this.meta.setDisplayName(Text.colorize(name));
    }

    public ItemBuilder(ItemStack from) {
        this.item = from;
        this.meta = this.item.hasItemMeta() ? this.item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(this.item.getType());
        this.lore = this.meta != null && this.meta.hasLore() ? this.meta.getLore() : new ArrayList<>();
    }

    public ItemBuilder setType(Material type) {
        this.item.setType(type);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    public ItemBuilder setDurability(short durability) {
        this.item.setDurability(durability);
        return this;
    }

    public ItemBuilder setData(MaterialData data) {
        this.item.setData(data);
        return this;
    }

    public ItemBuilder setData(byte data) {
        MaterialData materialData = this.item.getData();
        materialData.setData(data);
        this.item.setData(materialData);
        return this;
    }

    public ItemBuilder setName(String name) {
        this.meta.setDisplayName(Text.colorize(name));
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        this.lore = new ArrayList<>();
        for (String s : lore) {
            this.lore.add(Text.colorize(s));
        }
        this.meta.setLore(this.lore);
        return this;
    }

    public ItemBuilder addLore(String... lore) {
        for (String s : lore) {
            this.lore.add(Text.colorize(s));
        }
        this.meta.setLore(this.lore);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore != null ? Text.colorize(lore) : new ArrayList<>();
        this.meta.setLore(this.lore);
        return this;
    }

    public ItemBuilder clearLore() {
        return this.setLore(new ArrayList<>());
    }

    public ItemBuilder clearName() {
        this.meta.setDisplayName(null);
        return this;
    }

    public ItemBuilder setEnchants(Map<Enchantment, Integer> enchants) {
        for (Enchantment enchantment : enchants.keySet()) {
            if (this.meta.hasEnchant(enchantment)) {
                this.meta.removeEnchant(enchantment);
            }
            this.meta.addEnchant(enchantment, enchants.get(enchantment), true);
        }
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        this.meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder removeEnchant(Enchantment... enchantments) {
        Arrays.stream(enchantments).forEach(e -> this.meta.removeEnchant(e));
        return this;
    }

    public ItemBuilder addFlags(ItemFlag... flags) {
        this.meta.addItemFlags(flags);
        return this;
    }

    public ItemBuilder removeFlags(ItemFlag... flags) {
        this.meta.removeItemFlags(flags);
        return this;
    }

    public ItemBuilder clearFlags() {
        ItemFlag[] flags = (ItemFlag[]) this.meta.getItemFlags().toArray();
        this.meta.removeItemFlags(flags);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        this.meta.setUnbreakable(unbreakable);
        return this;
    }

    public ItemBuilder setGlowing(boolean glowing) {
        if (glowing) {
            this.meta.addEnchant(Enchantment.DURABILITY, 1, true);
            this.meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else if (this.meta.hasEnchants() && this.meta.hasEnchant(Enchantment.DURABILITY)) {
            this.meta.removeEnchant(Enchantment.DURABILITY);
            this.meta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return this;
    }

    public ItemStack build() {
        if (!this.lore.isEmpty()) {
            this.meta.setLore(this.lore);
        }
        this.item.setItemMeta(Bukkit.getItemFactory().isApplicable(this.meta, this.item) ? this.meta : Bukkit.getItemFactory().getItemMeta(this.item.getType()));
        return this.item;
    }
}