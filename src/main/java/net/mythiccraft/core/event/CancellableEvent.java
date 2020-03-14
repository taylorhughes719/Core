package net.mythiccraft.core.event;

import net.mythiccraft.core.Core;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * A cancellable event
 */
public abstract class CancellableEvent extends Event implements Cancellable {

    private Core plugin;
    private boolean cancel;

    public CancellableEvent(Core plugin) {
        this.plugin = plugin;
        this.cancel = false;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public Core getPlugin() {
        return plugin;
    }
}
