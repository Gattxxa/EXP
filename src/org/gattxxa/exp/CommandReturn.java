package org.gattxxa.exp;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class CommandReturn implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		
		if (player.getLevel() > 0) {
			
			
			Location location = player.getServer().getWorld("world").getSpawnLocation();
			player.teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN);
			player.setLevel(player.getLevel()/2);
			
			player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, (float)0.5);
			player.getWorld().playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1, 1);
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 160, 100, true, true));
			player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 29, 0, false, false));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30, 5, false, false));
			
			return true;
		}
		
		else {
			player.getWorld().playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
			player.sendMessage(ChatColor.RED + "経験値が足りません！");
			return true;
		}
		
	}
}
