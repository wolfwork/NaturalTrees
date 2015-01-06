package de.TrustedCreeper.NaturalTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;


public class NaturalTreesEventHandler implements Listener {

	
	private final NaturalTrees plugin;

	public NaturalTreesEventHandler(NaturalTrees plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent e) {
		if(e.getBlock() == null) return;
		if(e.isCancelled()) return;
		if(NaturalTrees.getInstance().getPluginSettings().isDisabledInWorld(e.getBlock().getWorld().getName())) return;
		
		if(NaturalTrees.getInstance().getPluginSettings().existWorldGuard()) {
			WorldGuardPlugin wg = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
			if(wg.getRegionManager(e.getBlock().getWorld()).getApplicableRegions(e.getBlock().getLocation()).size() > 0) {
				if(NaturalTrees.getInstance().getPluginSettings().isDisabledInRegion()) {
					return;
				}
			}
		}
		if((e.getBlock().getType() == Material.LEAVES) || e.getBlock().getType() == Material.LEAVES_2) {
			e.setCancelled(true);
			if(!NaturalTrees.getInstance().getPluginSettings().canDecay()) return;
			final LeavesType lt = TreeManager.getLeavesType(e.getBlock());
			if(TreeManager.canDropApple()) {
				if(lt == LeavesType.OAK) {
					ItemStack apple = new ItemStack(Material.APPLE, 1);
					e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), apple);
				}
			}
			if(TreeManager.canDrop()) {
				
				final ItemStack saplingItemStack = lt.getSapling();
				final Item sapling = e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), saplingItemStack);
				if(TreeManager.canGrow()) {
					if(NaturalTrees.getInstance().getPluginSettings().existWorldGuard()) {
						WorldGuardPlugin wg = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
						if(wg.getRegionManager(e.getBlock().getWorld()).getApplicableRegions(e.getBlock().getLocation()).size() > 0) {
							if(!NaturalTrees.getInstance().getPluginSettings().isPlantingSaplingsInRegion()) {
								return;
							}
						}
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(NaturalTrees.getInstance(), new Runnable() {
						
						@Override
						public void run() {
							if(sapling == null) return;
							if(sapling.isDead()) return;
							Block under = sapling.getLocation().subtract(0,1,0).getBlock();
							List<Material> growOn = new ArrayList<Material>(Arrays.asList(Material.DIRT, Material.GRASS));
							if(growOn.contains(under.getType())) {
								Block b = sapling.getLocation().getBlock();
								
								if((b.getType() == Material.LONG_GRASS) || (b.getType() == Material.AIR)) {
									b.setType(Material.SAPLING);
									b.setData((byte) lt.getID());
									if(NaturalTrees.getInstance().getPluginSettings().growInstant()) {
										b.setType(Material.AIR);
										b.getWorld().generateTree(b.getLocation(), LeavesType.toTreeType(lt));
									}
									sapling.remove();
									
								}
							}
						}
					}, NaturalTrees.getInstance().getPluginSettings().getTimeToFirmlyGrow() * 20);
				}
			}
			e.getBlock().setType(Material.AIR);
		}
	}
}
