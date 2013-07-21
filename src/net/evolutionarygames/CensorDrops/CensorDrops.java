package net.evolutionarygames.CensorDrops;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public final class CensorDrops extends JavaPlugin {
	@Override
	public void onEnable(){
		PluginManager pm = this.getServer().getPluginManager();
		Listener dL = new DropsListener();
		pm.registerEvents(dL, this);
		
	}
	@Override
	public void onDisable(){
		HandlerList.unregisterAll(this);
	}
	
}

