package de.TrustedCreeper.NaturalTrees;

import org.bukkit.ChatColor;


public class PluginSettings {
	private String messageNoPermission, messageConfigReload;
	private int dropRate, growthRate, timeToFirmlyGrow;
	private boolean decay, metrics;
	
	public PluginSettings() {
		messageNoPermission = ChatColor.translateAlternateColorCodes('&', NaturalTrees.getInstance().getConfig().getString("messages.no_permission"));
		messageConfigReload = ChatColor.translateAlternateColorCodes('&', NaturalTrees.getInstance().getConfig().getString("messages.config_reloaded"));
		dropRate = NaturalTrees.getInstance().getConfig().getInt("config.droprate");
		growthRate = NaturalTrees.getInstance().getConfig().getInt("config.growthrate");
		timeToFirmlyGrow = NaturalTrees.getInstance().getConfig().getInt("config.timetofirmlygrow");
		decay = NaturalTrees.getInstance().getConfig().getBoolean("config.decay");
		metrics = NaturalTrees.getInstance().getConfig().getBoolean("config.metrics");
	}
	
	public int getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(int growthRate) {
		this.growthRate = growthRate;
	}
	
	public String getMessageNoPermission() {
		return messageNoPermission;
	}

	public void setMessageNoPermission(String messageNoPermission) {
		this.messageNoPermission = messageNoPermission;
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
