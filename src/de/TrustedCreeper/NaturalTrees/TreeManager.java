package de.TrustedCreeper.NaturalTrees;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class TreeManager {
	public static LeavesType getLeavesType(Block b) {
		if(b.getType() == Material.LEAVES) {
			switch (b.getData()) {
			case 8:
				return LeavesType.OAK;
			case 9:
				return LeavesType.SPRUCE;
			case 10:
				return LeavesType.BIRCH;
			case 11:
				return LeavesType.JUNGLE;
			}
		}
		if(b.getType() == Material.LEAVES_2) {
			switch (b.getData()) {
			case 8:
				return LeavesType.ACACIA;
			case 9:
				return LeavesType.BLACK_OAK;
			}
		}
		return null;
	}
	
	public static boolean canDrop() {
		return calculateProbability(NaturalTrees.getInstance().getPluginSettings().getDropRate());
	}
	
	public static boolean canGrow() {
		return calculateProbability(NaturalTrees.getInstance().getPluginSettings().getGrowthRate());
	}
	
	public static boolean calculateProbability(int percentage) {
		if(percentage > 100) percentage = 100;
		if(percentage < 0) percentage = 0;
		if(percentage == 100) return true;
		if(percentage == 0) return false;
		if(getRandomInt(0, 100) < percentage) {
			return true;
		}
		return false;
	}
	
	public static int getRandomInt(int low, int high){
		Random r = new Random();
		return r.nextInt(high-low) + low;
	}
}
