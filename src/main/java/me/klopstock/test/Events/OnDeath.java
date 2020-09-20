package me.klopstock.test.Events;

import me.klopstock.test.Commands.Start;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    Start start;

    public OnDeath(Start start){
        this.start = start;
    }

    @EventHandler void onDeath(PlayerDeathEvent e){
        e.setDeathMessage("");
        Player deadPlayer = e.getEntity();
        if (deadPlayer == this.start.getImposter()){
            Bukkit.broadcastMessage("The " + ChatColor.RED + "Imposter" + ChatColor.WHITE + " was Killed");
            Bukkit.broadcastMessage("The Imposter was " + ChatColor.RED + deadPlayer.getDisplayName());
            teleportAndSetSurvival();
        }else{
            int alivePlayerCount = 0;
            for(Player player: Bukkit.getOnlinePlayers()){
                if (player.getGameMode() == GameMode.SURVIVAL){
                    alivePlayerCount++;
                }
            }
            if (alivePlayerCount == 1){
                Bukkit.broadcastMessage("The " + ChatColor.RED + "Imposter" + ChatColor.WHITE + " won");
                Bukkit.broadcastMessage("The Imposter was " + ChatColor.RED + this.start.getImposter());
                teleportAndSetSurvival();
            }else{
                deadPlayer.setGameMode(GameMode.SPECTATOR);
            }
        }
    }

    private void teleportAndSetSurvival(){
        Location spawn = this.start.getImposter().getWorld().getSpawnLocation();
        for(Player player: Bukkit.getOnlinePlayers()){
            player.teleport(spawn);
            player.setGameMode(GameMode.SURVIVAL);
        }
    }
}