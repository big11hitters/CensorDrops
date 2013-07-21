package net.evolutionarygames.CensorDrops;

import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DropsListener implements Listener{
	@EventHandler (priority = EventPriority.HIGH)
	public void DisableDrops(EntityDeathEvent evt){
		if(evt.getEntity() instanceof PigZombie){
			evt.getDrops().clear();
		}
	}
}
