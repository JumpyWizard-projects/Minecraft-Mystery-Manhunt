package me.klopstock.test.Events;

import me.klopstock.test.Commands.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class OnClear implements Listener {

    Start start;

    public OnClear(Start start){
        this.start = start;
    }

    @EventHandler
    void EnderDragonDeath(EntityDeathEvent e){
        if (e.getEntity() instanceof EnderDragon){
            Bukkit.broadcastMessage("Ender Dragon was killed the " + ChatColor.RED +  "Imposter " + ChatColor.WHITE + "lost.");
            Bukkit.broadcastMessage("The Imposter was " + ChatColor.RED + this.start.getImposter().getDisplayName());
        }
    }
}