package net.mythiccraft.core.util;

import net.mythiccraft.core.Core;

/**
 * A manager class.
 *
 * @author Taylor Hughes
 */
public class Manager {

    private Core plugin;

    public Manager(Core plugin) {
        this.plugin = plugin;
    }

    public Core getPlugin() {
        return plugin;
    }
}
