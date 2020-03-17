package net.mythiccraft.core;

import net.mythiccraft.core.config.FileConfig;

import net.mythiccraft.core.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import org.jetbrains.annotations.NotNull;

/**
 * The main class of the Core plugin.
 */
public final class Core extends JavaPlugin {

    private static Core instance;
    private FileConfig mainConfig;
    private FileConfig messagesConfig;
    private FileConfig kitsConfig;
    private FileConfig dataConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!this.getDataFolder().exists() && !this.getDataFolder().mkdir()) {
            this.getLogger().severe("Failed to create plugin directory! The plugin will now be disabled!");
            this.setEnabled(false);
        }

        // Set static instance of the plugin
        instance = this;

        // Initialize configurations
        this.mainConfig = new FileConfig(this, "config.yml");
        this.messagesConfig = new FileConfig(this, "messages.yml");
        this.kitsConfig = new FileConfig(this, "kits.yml");
        this.dataConfig = new FileConfig(this, "data.yml");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // Unload configurations
        this.dataConfig = null;
        this.kitsConfig = null;
        this.messagesConfig = null;
        this.mainConfig = null;

        HandlerList.unregisterAll(instance);

        // Just to be safe, set the instance to null
        instance = null;

        HandlerList.unregisterAll(this);
    }

    /**
     * Get the instance of the plugin.
     *
     * @return The plugin's static instance.
     */
    public static Core getInstance() {
        return instance;
    }

    public String getMessage(String path) {
        return messagesConfig.getString(path);
    }

    public Location getSpawn() {
        World world = Bukkit.getWorld(dataConfig.getString("Spawn.World"));
        return new Location(world, dataConfig.getDouble("Spawn.X"), dataConfig.getDouble("Spawn.Y"), dataConfig.getDouble("Spawn.Z"), (float) dataConfig.getConfig().getDouble("Spawn.Yaw"), (float) dataConfig.getConfig().getDouble("Spawn.Pitch"));
    }

    public FileConfig getMessagesConfig() {
        return messagesConfig;
    }

    public FileConfig getDataConfig() {
        return dataConfig;
    }

    @Override
    public @NotNull FileConfiguration getConfig() {
        return this.mainConfig.getConfig();
    }

    public FileConfig getKitsConfig() {
        return kitsConfig;
    }

    public FileConfig getMainConfig() {
        return mainConfig;
    }

    @Override
    public void reloadConfig() {
        getLogger().info("Reloading configuration files.");
        mainConfig.reload();
        messagesConfig.reload();
        kitsConfig.reload();
        dataConfig.reload();
    }

    public void reloadConfigs() {
        reloadConfig();
    }
}
