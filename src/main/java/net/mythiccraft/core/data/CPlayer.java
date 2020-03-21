package net.mythiccraft.core.data;

import net.mythiccraft.core.util.Text;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * A player data class (A Core (C)Player)
 */
public class CPlayer {

    private Player player;
    private UUID uuid;
    private double balance;
    private boolean flying;
    private boolean muted;

    public CPlayer(Player player) {
        this.player = player;
        this.uuid = player.getUniqueId();
        this.balance = 0.0;
        this.flying = false;
    }

    public CPlayer(Player player, double balance, boolean flying) {
        this.player = player;
        this.balance = balance;
        this.flying = flying;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return player.getName();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void giveMoney(double amount) {
        this.balance += amount;
    }

    public void takeMoney(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
        }
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
        player.setFlying(false);
    }

    public UUID getUUID() {
        return uuid;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setNickname(String nickname) {
        player.setDisplayName(Text.colorize(nickname));
    }
}
