package net.mythiccraft.core.data;

import net.mythiccraft.core.Core;

/**
 * @author Taylor Hughes
 */
public class DataManager {

    private Core plugin;
    private Storage storage;

    public DataManager(Core plugin) {
        this.plugin = plugin;
    }

    public Core getPlugin() {
        return plugin;
    }

    public Storage getStorage() {
        return storage;
    }
}
