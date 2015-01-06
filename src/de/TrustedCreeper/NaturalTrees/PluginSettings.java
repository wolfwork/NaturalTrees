package de.TrustedCreeper.NaturalTrees;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;


public class PluginSettings {
	private String messageNoPermission, messageConfigReload;
	private int dropRate, growthRate, timeToFirmlyGrow, appleDropRate;
	private boolean decay, metrics, disableInRegion, plantSaplingsInRegion, existWorldGuard;
	private final boolean growInstant;
	private List<String> disabledInWorlds = new ArrayList<String>(); 
	public PluginSettings() {
		messageNoPermission = ChatColor.translateAlternateColorCodes('&', NaturalTrees.getInstance().getConfig().getString("messages.no_permission"));
		messageConfigReload = ChatColor.translateAlternateColorCodes('&', NaturalTrees.getInstance().getConfig().getString("messages.config_reloaded"));
		dropRate = NaturalTrees.getInstance().getConfig().getInt("config.droprate");
		appleDropRate = NaturalTrees.getInstance().getConfig().getInt("config.apple_droprate");
		growthRate = NaturalTrees.getInstance().getConfig().getInt("config.growthrate");
		timeToFirmlyGrow = NaturalTrees.getInstance().getConfig().getInt("config.timetofirmlygrow");
		decay = NaturalTrees.getInstance().getConfig().getBoolean("config.decay");
		growInstant = NaturalTrees.getInstance().getConfig().getBoolean("config.grow_instant");
		metrics = NaturalTrees.getInstance().getConfig().getBoolean("config.metrics");
		disableInRegion = NaturalTrees.getInstance().getConfig().getBoolean("config.worldguard.disable_naturaltrees_in_regions");
		plantSaplingsInRegion = NaturalTrees.getInstance().getConfig().getBoolean("config.worldguard.plant_sapling_in_regions");
		existWorldGuard(Bukkit.getPluginManager().getPlugin("WorldEdit") != null);
		disabledInWorlds = NaturalTrees.getInstance().getConfig().getStringList("config.disabled_worlds");
	}
	
	public boolean growInstant() {
		return growInstant;
	}
	
	public boolean isDisabledInWorld(String world) {
		return disabledInWorlds.contains(world);
	}
	public int getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(int growthRate) {
		this.growthRate = growthRate;
	}
	
	public int getAppleDropRate() {
		return appleDropRate;
	}

	public void setAppleDropRate(int appleDropRate) {
		this.appleDropRate = appleDropRate;
	}

	public String getMessageNoPermission() {
		return messageNoPermission;
	}

	public void setMessageNoPermission(String messageNoPermission) {
		this.messageNoPermission = messageNoPermission;
	}

	public boolean isDisabledInRegion() {
		return disableInRegion;
	}

	public void disableInRegion(boolean disableInRegion) {
		this.disableInRegion = disableInRegion;
	}

	public boolean isPlantingSaplingsInRegion() {
		return plantSaplingsInRegion;
	}

	public void setPlantingSaplingsInRegion(boolean plantSaplingsInRegion) {
		this.plantSaplingsInRegion = plantSaplingsInRegion;
	}

	public boolean existWorldGuard() {
		return existWorldGuard;
	}

	public void existWorldGuard(boolean existWorldGuard) {
		this.existWorldGuard = existWorldGuard;
	}

	public String getMessageConfigReload() {
		return messageConfigReload;
	}

	public void setMessageConfigReload(String messageConfigReload) {
		this.messageConfigReload = messageConfigReload;
	}

	public int getDropRate() {
		return dropRate;
	}

	public void setDropRate(int dropRate) {
		this.dropRate = dropRate;
	}

	public boolean canDecay() {
		return decay;
	}

	public void setDecay(boolean decay) {
		this.decay = decay;
	}

	public boolean isMetrics() {
		return metrics;
	}

	public void setMetrics(boolean metrics) {
		this.metrics = metrics;
	}

	public int getTimeToFirmlyGrow() {
		return timeToFirmlyGrow;
	}

	public void setTimeToFirmlyGrow(int timeToFirmlyGrow) {
		this.timeToFirmlyGrow = timeToFirmlyGrow;
	}

	
	
	
}
