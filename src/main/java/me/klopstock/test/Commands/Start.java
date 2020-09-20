package me.klopstock.test.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class Start implements CommandExecutor {

    Player imposter;

    public Player getImposter(){
        return this.imposter;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        imposter = randomPlayer();
        Location spawn = imposter.getWorld().getSpawnLocation();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.teleport(spawn);
            player.setGameMode(GameMode.SURVIVAL);
            if (player == imposter) {
                player.sendMessage("You are the " + ChatColor.RED + "Imposter");
            }else{
                player.sendMessage("You are a " + ChatColor.GREEN + "Crewmate");
            }
        }

        return true;
    }

    private Player randomPlayer() {
        int randomPlayer = new Random().nextInt(Bukkit.getOnlinePlayers().size());
        return (Player) Bukkit.getOnlinePlayers().toArray()[randomPlayer];
    }
}