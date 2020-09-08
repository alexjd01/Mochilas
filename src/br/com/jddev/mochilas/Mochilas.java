package br.com.jddev.mochilas;

import br.com.jddev.mochilas.commands.CommandGivemochila;
import br.com.jddev.mochilas.commands.CommandMochila;
import br.com.jddev.mochilas.listeners.ListenerInventoryClick;
import br.com.jddev.mochilas.listeners.ListenerPlayerInteract;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Mochilas extends JavaPlugin {

    public void onEnable() {

        registerCommands();
        registerEvents();

        Bukkit.getConsoleSender().sendMessage("§f-------------------");
        Bukkit.getConsoleSender().sendMessage("§6JD DEV.");
        Bukkit.getConsoleSender().sendMessage("§6Iniciando Mochilas.");
        Bukkit.getConsoleSender().sendMessage("§6Feito por AlexJD.");
        Bukkit.getConsoleSender().sendMessage("§f-------------------");

        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists());
        saveResource("config.yml", false);

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage("§f-----------------------");
        Bukkit.getConsoleSender().sendMessage("§6JD DEV.");
        Bukkit.getConsoleSender().sendMessage("§6Desabilitando Mochilas.");
        Bukkit.getConsoleSender().sendMessage("§6Feito por AlexJD.");
        Bukkit.getConsoleSender().sendMessage("§f-----------------------");

    }

    private void registerCommands(){

        getCommand("givemochila").setExecutor(new CommandGivemochila());
        getCommand("mochila").setExecutor(new CommandMochila());

    }

    private void registerEvents(){

        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new ListenerPlayerInteract(), this);
        pm.registerEvents(new ListenerInventoryClick(), this);

    }

    public static Mochilas getInstance(){ return Mochilas.getPlugin(Mochilas.class);}

}
