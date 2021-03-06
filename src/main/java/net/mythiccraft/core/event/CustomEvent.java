package net.mythiccraft.core.event;

import net.mythiccraft.core.Core;

import org.bukkit.event.Event;

/**
 * @author Taylor Hughes
 */
public abstract class CustomEvent extends Event {

    private Core plugin;

    public CustomEvent(Core plugin) {
        this.plugin = plugin;
    }

    public Core getPlugin() {
        return plugin;
    }
}
