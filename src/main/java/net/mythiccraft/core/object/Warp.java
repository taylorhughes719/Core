package net.mythiccraft.core.object;

import org.bukkit.Location;

/**
 * A warp object
 */
public class Warp {

    private String name;
    private Location location;

    public Warp(String name, Location location) {
        this.name = name;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
