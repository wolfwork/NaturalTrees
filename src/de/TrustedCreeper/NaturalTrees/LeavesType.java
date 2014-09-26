package de.TrustedCreeper.NaturalTrees;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public enum LeavesType {
	OAK(new ItemStack(Material.SAPLING, 1, (short) 0), 0),
	SPRUCE(new ItemStack(Material.SAPLING, 1, (short) 1), 1),
	BIRCH(new ItemStack(Material.SAPLING, 1, (short) 2), 2),
	JUNGLE(new ItemStack(Material.SAPLING, 1, (short) 3), 3),
	ACACIA(new ItemStack(Material.SAPLING, 1, (short) 4), 4),
	BLACK_OAK(new ItemStack(Material.SAPLING, 1, (short) 5), 5);
	
	ItemStack sapling;
	int id;
	LeavesType(ItemStack sapling, int id) {
		this.sapling = sapling;
		this.id = id;
	}
	
	public ItemStack getSapling() {
		return sapling;
	}
	
	public int getID() {
		return id;
	}
}
