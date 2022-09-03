package org.gattxxa.exp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("return").setExecutor(new CommandReturn());
	}
	
	@Override
	public void onDisable() {

	}
	
	@EventHandler
	public void keepEXP(PlayerDeathEvent event) {
		event.setDroppedExp(0);
		event.setKeepLevel(true);
	}
}
