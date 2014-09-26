package de.TrustedCreeper.NaturalTrees;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.metrics.Metrics;

public class NaturalTrees extends JavaPlugin {
	@Override
	public void onEnable() {
		registerEvents();
		loadConfig();
		loadPluginSettings();
		NaturalTreesCommands command = new NaturalTreesCommands(this);
		getCommand("nt").setExecutor(command);
		
		if(getConfig().getBoolean("config.metrics")) {
			try {
			    Metrics metrics = new Metrics(this);
			    metrics.start();
			    Bukkit.getLogger().log(Level.INFO, "[NaturalTrees] Enabled Plugin-Metrics!");
			} catch (IOException e) {
				Bukkit.getLogger().log(Level.INFO, "[NaturalTrees] Error: Cant enable Plugin-Metrics!");
				e.printStackTrace();
			}
		}
	}
	
	public void onReload() {
		reloadPluginSettings();
	}
	
	private NaturalTreesEventHandler events;
	public void registerEvents() {
		this.events = new NaturalTreesEventHandler(this);
	}
	
	File config = new File("plugins/NaturalTrees/config.yml");
	public void loadConfig() {
		getConfig().addDefault("config.droprate", 10);
		getConfig().addDefault("config.growthrate", 100);
		getConfig().addDefault("config.timetofirmlygrow", 10);
		getConfig().addDefault("config.decay", true);
		getConfig().addDefault("config.metrics", true);
		
		getConfig().addDefault("messages.no_permission", "&8[&2NaturalTrees&8] &cYou don't have permission!");
		getConfig().addDefault("messages.config_reloaded", "&8[&2NaturalTrees&8] &2Reloaded configuration file!");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public static NaturalTrees getInstance() {
		return (NaturalTrees) Bukkit.getPluginManager().getPlugin("NaturalTrees");
	}
	
	private PluginSettings pluginSettings;
	
	public void loadPluginSettings() {
		pluginSettings = new PluginSettings();
	}
	
	public void reloadPluginSettings() {
		getInstance().reloadConfig();
		pluginSettings = new PluginSettings();
	}
	
	public PluginSettings getPluginSettings() {
		return pluginSettings;
	}
}



