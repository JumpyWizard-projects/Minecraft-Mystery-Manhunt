package me.klopstock.test;

import me.klopstock.test.Commands.Start;
import me.klopstock.test.Events.OnClear;
import me.klopstock.test.Events.OnDeath;
import me.klopstock.test.Events.OnMessage;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Test extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        Start start = new Start();
        Objects.requireNonNull(getCommand("start")).setExecutor(start);
        pluginManager.registerEvents(new OnDeath(start), this);
        pluginManager.registerEvents(new OnMessage(), this);
        pluginManager.registerEvents(new OnClear(start), this);
    }
}
