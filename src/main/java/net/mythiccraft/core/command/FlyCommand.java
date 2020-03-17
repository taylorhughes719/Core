package net.mythiccraft.core.command;

import net.mythiccraft.core.Core;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * @author Taylor Hughes
 */
public class FlyCommand extends CCommand {

    public FlyCommand(Core plugin) {
        super(plugin, "fly");
    }

    @Override
    public boolean onPlayerCommand(Player sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender.hasPermission("core.fly")) {
                if (sender.getAllowFlight()) {
                    sender.setAllowFlight(false);
                    if (sender.isFlying()) sender.setFlying(false);
                } else {
                    sender.setFlying(true);
                    sender.setAllowFlight(true);
                }
            }
        }
        return false;
    }

    @Override
    public boolean onConsoleCommand(ConsoleCommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
