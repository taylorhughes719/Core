package net.mythiccraft.core.util;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Taylor Hughes
 */
public class ItemUtil {

    @SuppressWarnings("ConstantConditions")
    public static ItemStack readItem(ConfigurationSection config) {
        ItemBuilder item = new ItemBuilder(Material.AIR);

        if (config.contains("Material")) {
            if (Objects.requireNonNull(config.getString("Material")).contains(";")) {
                String[] s = config.getString("Material").split(";");
                int data = Integer.parseInt(s[1]);
                item.setData((byte) data);
                item.setType(Material.getMaterial(s[0]));
            } else {
                item.setType(Material.getMaterial(Objects.requireNonNull(config.getString("Material", "AIR"))));
            }
        }
        if (config.contains("Amount")) {
            item.setAmount(config.getInt("Amount", 1));
        }
        if (config.contains("Name")) {
            item.setName(config.getString("Name"));
        }
        if (config.contains("Lore")) {
            item.setLore(config.getStringList("Lore"));
        }
        if (config.contains("Glowing")) {
            item.setGlowing(config.getBoolean("Glowing", false));
        }
        if (config.contains("Enchants")) {
            Map<Enchantment, Integer> enchants = new HashMap<>();
            for (String s : config.getStringList("Enchants")) {
                String[] s1 = s.split(" ");
                //enchants.put(Enchantment.getByKey())
            }
        }

        return item.build();
    }
}
