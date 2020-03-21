package net.mythiccraft.core.config;

import com.google.common.io.ByteStreams;
import net.mythiccraft.core.Core;
import net.mythiccraft.core.util.ItemUtil;
import org.bukkit.inventory.ItemStack;

import java.io.FileOutputStream;
import java.util.Objects;

/**
 * A kit configuration file
 */
public class KitConfig extends FileConfig {

    private String name;
    private boolean defaultKit;

    public KitConfig(Core plugin, String name, boolean defaultKit) {
        super(plugin, "/kits/" + name + ".yml");
        this.name = name;
        this.defaultKit = defaultKit;
    }

    public String getName() {
        return name;
    }

    public boolean isDefaultKit() {
        return defaultKit;
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void load() {
        this.getPlugin().getLogger().info("Loading file configuration: " + this.getFileName());
        try {
            if (this.getFile().exists()) {
                this.getConfig().load(this.getFile());
            }
            else {
                if (defaultKit) {
                    ByteStreams.copy(Objects.requireNonNull(getPlugin().getResource(getFileName())), new FileOutputStream(getFileName()));
                } else {
                     if (this.getFile().createNewFile()) {
                         getPlugin().getLogger().info("Creating new kit configuration for " + getFileName());
                     }
                }
                this.getConfig().load(this.getFile());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ItemStack getHelmet() {
        return ItemUtil.readItem(getConfigSection("Helmet"));
    }

    public ItemStack getChestplate() {
        return ItemUtil.readItem(getConfigSection("Chestplate"));
    }

    public ItemStack getLeggings() {
        return ItemUtil.readItem(getConfigSection("Leggings"));
    }

    public ItemStack getBoots() {
        return ItemUtil.readItem(getConfigSection("Boots"));
    }
}
