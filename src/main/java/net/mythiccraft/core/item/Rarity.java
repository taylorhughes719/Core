package net.mythiccraft.core.item;

import org.bukkit.ChatColor;

/**
 * Rarities
 */
public enum Rarity {

    COMMON(ChatColor.WHITE + "Common"),
    UNCOMMON(ChatColor.GRAY + "Uncommon"),
    RARE(ChatColor.DARK_AQUA + "Rare"),
    EPIC(ChatColor.LIGHT_PURPLE + "Epic"),
    LEGENDARY(ChatColor.GOLD + "Legendary"),
    GODLIKE(ChatColor.DARK_RED + "Godlike");

    private final String displayName;

    Rarity(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
