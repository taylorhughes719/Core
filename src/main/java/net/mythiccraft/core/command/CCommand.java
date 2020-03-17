package net.mythiccraft.core.command;

import net.mythiccraft.core.Core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class CCommand implements CommandExecutor {

    private Core plugin;
    private String cmd;

    public CCommand(Core plugin, String cmd) {
        this.plugin = plugin;
        this.cmd = cmd;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase(this.cmd)) {
            if (sender instanceof ConsoleCommandSender) {
                return this.onConsoleCommand((ConsoleCommandSender) sender, command, label, args);
            } else {
                return this.onPlayerCommand((Player) sender, command, label, args);
            }
        }
        return false;
    }

    public abstract boolean onPlayerCommand(Player sender, Command command, String label, String[] args);


    public abstract boolean onConsoleCommand(ConsoleCommandSender sender, Command command, String label, String[] args);

    public Core getPlugin() {
        return this.plugin;
    }

    public boolean noPermission(Player player) {
        player.sendMessage(Objects.requireNonNull(this.plugin.getConfig().getString("No-Permission.Command")));
        return false;
    }
}
