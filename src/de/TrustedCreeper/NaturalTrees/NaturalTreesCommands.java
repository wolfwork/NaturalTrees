package de.TrustedCreeper.NaturalTrees;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NaturalTreesCommands implements CommandExecutor {

	private final NaturalTrees plugin;

	public NaturalTreesCommands(NaturalTrees plugin) {
		this.plugin = plugin;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(command.getName().equalsIgnoreCase("nt")) {
			if(args.length == 0) {
				if(sender.hasPermission("naturaltrees.info")) {
					sender.sendMessage("");
					sender.sendMessage("§7   §2NaturalTrees");
					sender.sendMessage("§7   ============");
					sender.sendMessage("");
					sender.sendMessage("§7 > §6This plugin implements more natural saplings which growth by themselves.");
					sender.sendMessage("");
					sender.sendMessage("§7 > §6/nt reload §7- §2Reload the NaturalTrees config");
					sender.sendMessage("");
					sender.sendMessage("§7 > §6Developed by §5TrustedCreeper");
					sender.sendMessage("");
				} else {
					sender.sendMessage(NaturalTrees.getInstance().getPluginSettings().getMessageNoPermission());
				}
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(sender.hasPermission("naturaltrees.reload")) {
						NaturalTrees.getInstance().reloadConfig();
						NaturalTrees.getInstance().loadPluginSettings();
						sender.sendMessage(NaturalTrees.getInstance().getPluginSettings().getMessageConfigReload());
					} else {
						sender.sendMessage(NaturalTrees.getInstance().getPluginSettings().getMessageNoPermission());
					}
				}
			}
			return true;
		}
		return false;
	}
}