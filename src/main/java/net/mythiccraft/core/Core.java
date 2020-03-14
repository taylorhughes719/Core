package net.mythiccraft.core;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The main class of the Core plugin.
 *
 * @author Taylor Hughes
 */
public final class Core extends JavaPlugin {

    private static Core instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!this.getDataFolder().exists() && !this.getDataFolder().mkdir()) {
            this.getLogger().severe("Failed to create plugin directory! The plugin will now be disabled!");
            this.setEnabled(false);
        }

        // Set static instance of the plugin
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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
}
