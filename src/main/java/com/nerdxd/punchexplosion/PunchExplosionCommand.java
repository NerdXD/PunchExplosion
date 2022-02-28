package com.nerdxd.punchexplosion;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PunchExplosionCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player  = (Player) sender;
            player.sendMessage(ChatColor.RED + "Command Activated... Tnt will now spawn when you left click...");

        }


        return false;
    }

    @EventHandler
    public void onPunch(PlayerInteractEvent e) {

        Location loc = e.getPlayer().getEyeLocation();

        Vector direction = e.getPlayer().getLocation().getDirection();

        Location front = loc.add(direction);

        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player player = e.getPlayer();
            player.getLocation().getWorld().spawnEntity(front, EntityType.PRIMED_TNT);
        } else {
            return;
        }

    }


}
