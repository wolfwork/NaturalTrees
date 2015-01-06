package de.TrustedCreeper.NaturalTrees;

import org.bukkit.Material;
import org.bukkit.TreeType;
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
	
	public static org.bukkit.TreeType toTreeType(LeavesType leaf) {
		org.bukkit.TreeType tretyp = TreeType.TREE;
	        switch(leaf.getID()){
	        case 0:
	            tretyp = TreeType.TREE;
	        break;
	        case 1:
	            tretyp = TreeType.REDWOOD;
	        break;
	        case 2:
	            tretyp = TreeType.BIRCH;
	        break;
	        case 3:
	            tretyp = TreeType.JUNGLE;
	        break;
	        case 4:
	            tretyp = TreeType.ACACIA;
	        break;
	        case 5:
	            tretyp = TreeType.DARK_OAK;
	        break;
	        default:
	            tretyp = TreeType.TREE;
	        }
	        return tretyp;
	}
	
	public int getID() {
		return id;
	}
}
