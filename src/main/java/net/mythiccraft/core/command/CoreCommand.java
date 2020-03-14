package net.mythiccraft.core.command;

import net.mythiccraft.core.Core;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * @author Taylor Hughes
 */
public class CoreCommand extends CCommand {

    public CoreCommand(Core plugin) {
        super(plugin, "core");
    }

    @Override
    public boolean onPlayerCommand(Player sender, Command command, String label, String[] args) {
        return false;
    }

    @Override
    public boolean onConsoleCommand(ConsoleCommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
