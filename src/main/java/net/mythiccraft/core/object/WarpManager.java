package net.mythiccraft.core.object;

import net.mythiccraft.core.Core;
import net.mythiccraft.core.util.Manager;

import java.util.Map;

/**
 * @author Taylor Hughes
 */
public class WarpManager extends Manager {

    private Map<String, Warp> warps;

    public WarpManager(Core plugin) {
        super(plugin);
    }

    @Override
    public void shutdown() {
        if (!warps.isEmpty()) this.warps.clear();
        this.warps = null;
    }

    public Map<String, Warp> getWarps() {
        return warps;
    }

    public Warp getWarp(String name) {
        return warps.getOrDefault(name, null);
    }

    public boolean isWarp(String name) {
        return warps.containsKey(name) || warps.get(name) != null;
    }
}
