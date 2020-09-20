package me.klopstock.test.Events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnMessage implements Listener {



    @EventHandler
    void checkIfMessageShouldBeSend(AsyncPlayerChatEvent e){
        if (e.getPlayer().getGameMode() == GameMode.SPECTATOR){
            e.setCancelled(true);
        }
    }
}