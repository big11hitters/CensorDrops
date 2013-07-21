package net.evolutionarygames.CensorDrops;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DropsListener implements Listener{
	private CensorDrops plugin;
	public DropsListener(CensorDrops plugin){
		this.plugin = plugin;
	}
	@EventHandler
	public void disableDrops(EntityDeathEvent evt){
		FileConfiguration config = plugin.getConfig();
		if(config.getString("DisableAllMobDrops").equals("true")){
			evt.getDrops().clear();
		}
		else if(config.getString("DisableZombieDrops").equals("true")){
			if(evt.getEntity() instanceof Zombie)
				evt.getDrops().clear();
		}
		else if(config.getString("DisableCreeperDrops").equals("true")){
			if(evt.getEntity() instanceof Creeper)
				evt.getDrops().clear();
		}
		else if(config.getString("DisableSkeletonDrops").equals("true")){
			if(evt.getEntity() instanceof Skeleton)
				evt.getDrops().clear();
		}
	}
	@EventHandler
	public void setSpecialDrops(EntityDeathEvent evt){
		FileConfiguration config = plugin.getConfig();
		if(evt.getEntity() instanceof Zombie){
			evt.getEntity().getLocation().getWorld().dropItem(evt.getEntity().getLocation(), new ItemStack(config.getInt("Zombie")));
		}
	}
}
