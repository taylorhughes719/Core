package net.mythiccraft.core.util;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * A collection of player-related utilities.
 *
 * @version 1.0.0
 */
public class Players {

    /**
     * Is the given player online?
     *
     * @param player the player
     * @return true if the player is
     */
    public static boolean isOnline(String player) {
        return getPlayer(player) != null;
    }

    /**
     * Get the given player
     *
     * @param player the player name
     * @return the player or null
     */
    public static Player getPlayer(String player) {
        return Bukkit.getPlayer(player);
    }

    /**
     * Get the off hand
     *
     * @param p the player
     * @return the item
     */
    public static ItemStack getOffHand(Player p) {
        return p.getInventory().getItemInOffHand();
    }

    /**
     * Get the main hand
     *
     * @param p the player
     * @return the item
     */
    public static ItemStack getMainHand(Player p) {
        return p.getInventory().getItemInMainHand();
    }

    /**
     * Set off hand
     *
     * @param p the player
     * @param is the item stack
     */
    public static void setOffHand(Player p, ItemStack is) {
        p.getInventory().setItemInOffHand(is);
    }

    /**
     * Set main hand
     *
     * @param p the player
     * @param is the item stack
     */
    public static void setMainHand(Player p, ItemStack is) {
        p.getInventory().setItemInMainHand(is);
    }

    /**
     * Swap hands (off and main items)
     *
     * @param p the player
     */
    public static void swapHands(Player p) {
        ItemStack main = getMainHand(p).clone();
        setMainHand(p, getOffHand(p));
        setOffHand(p, main);
    }

    /**
     * Is there any player online?
     *
     * @return true if at least one player is online
     */
    public static boolean isAnyOnline() {
        return Bukkit.getOnlinePlayers().size() <= 0;
    }

    /**
     * Get all players in the given world
     *
     * @param world the world
     * @return the players
     */
    public static List<Player> inWorld(World world) {
        return new ArrayList<>(world.getPlayers());
    }

    /**
     * Get all players in the given chunk
     *
     * @param chunk the chunk
     * @return the list of players
     */
    public static List<Player> inChunk(Chunk chunk) {
        Entity[] entities = chunk.getEntities();
        return Arrays.stream(entities).filter(entity -> entity.getType() == EntityType.PLAYER).map(entity -> (Player) entity).collect(Collectors.toList());
    }


    /**
     * Checks if anyone is online
     *
     * @return Returns true if there is at least one player online.
     */
    public static boolean isAnyoneOnline() {
        return !getPlayers().isEmpty();
    }

    /**
     * Get the player count
     *
     * @return the player count
     */
    public static int getPlayerCount() {
        return getPlayers().size();
    }

    /**
     * Get the player with the specified UUID.
     *
     * @param id The player UUID
     * @return The player with the matching UUID or null if not found.
     */
    public static Player getPlayer(UUID id) {
        return Bukkit.getPlayer(id);
    }

    /**
     * Search for multiple player matches. If there is an identical match, nothing
     * else will be searched. If there is multiple ignored case matches, partials
     * will not be matched. Else it will match all partials.
     *
     * @param search the search query
     * @return a list of partial matches
     */
    public List<Player> getPlayers(String search) {
        List<Player> players = getPlayers();
        List<Player> found = players.stream().filter(i -> i.getName().equals(search)).collect(Collectors.toList());
        players.stream().filter(i -> i.getName().equalsIgnoreCase(search)).forEach(found::add);
        players.stream().filter(i -> i.getName().toLowerCase().contains(search.toLowerCase())).forEach(found::add);
        return found;
    }

    /**
     * Returns a list of ops
     *
     * @return ops in List
     */
    public static List<Player> getPlayersWithOP() {
        return isAnyOnline() ? new ArrayList<>() : getPlayers().stream().filter(player -> !player.isOp()).collect(Collectors.toList());
    }

    /**
     * Returns a list of non ops
     *
     * @return non op list
     */
    public static List<Player> getPlayersWithoutOP() {
        return isAnyOnline() ? new ArrayList<>() : getPlayers().stream().filter(player -> !player.isOp()).collect(Collectors.toList());
    }

    /**
     * Returns a list of players who has the given permissions.
     *
     * @param permission The permission to be checked.
     * @return a List of players without the specified permission.
     */
    public static List<Player> getPlayersWithPermission(String permission) {
        return (isAnyOnline()) ? new ArrayList<>() : getPlayers().stream().filter(player -> player.hasPermission(permission)).collect(Collectors.toList());
    }

    /**
     * Returns a list of players who do not have all of the given permissions.
     *
     * @param permission The permission to be checked.
     * @return a List of players without the specified permission.
     */
    public static List<Player> getPlayersWithoutPermission(String permission) {
        return (isAnyOnline()) ? new ArrayList<>() : getPlayers().stream().filter(player -> !player.hasPermission(permission)).collect(Collectors.toList());
    }

    /**
     * Returns a List of all players currently online
     *
     * @return a List representing all online players
     */
    public static List<Player> getPlayers() {
        return new ArrayList<>(Bukkit.getOnlinePlayers());
    }

    public static Player getAnyPlayer() {
        return (isAnyOnline()) ? null : getPlayers().get(0);
    }
}

