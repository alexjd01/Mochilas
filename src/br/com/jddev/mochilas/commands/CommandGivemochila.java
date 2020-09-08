package br.com.jddev.mochilas.commands;

import br.com.jddev.mochilas.Mochilas;
import br.com.jddev.mochilas.utils.MakeItem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CommandGivemochila implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String sdwa, String[] args) {

        if(!sender.hasPermission("jdmochilas.admin")){
            sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.No_Perm").replace("&", "§"));
            return false;
        }

        if(args.length == 0){
            sender.sendMessage("§cUtilize: /givemochila <player> <invasao/protecao/ferramentas/combate>.");
            return false;
        }

        if(args.length == 1){
            sender.sendMessage("§cUtilize: /givemochila <player> <invasao/protecao/ferramentas/combate>.");
            return false;
        }

        if(args.length == 2){
            Player t = Bukkit.getPlayerExact(args[0]);

            if(t == null){
                sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Player_Not_Found").replace("&", "§"));
                return false;
            }

            if(args[1].equalsIgnoreCase("invasao")){
                ItemStack mochila = new MakeItem(Mochilas.getInstance().getConfig().getString("Invasao.item.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Invasao.item.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Invasao.item.lore"))
                        .addGlow(Mochilas.getInstance().getConfig().getBoolean("Invasao.item.glow")).build();
                t.getInventory().addItem(mochila);
                sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Gived").replace("&", "§"));
            } else if(args[1].equalsIgnoreCase("protecao")){
                ItemStack mochila = new MakeItem(Mochilas.getInstance().getConfig().getString("Protecao.item.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Protecao.item.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Protecao.item.lore"))
                        .addGlow(Mochilas.getInstance().getConfig().getBoolean("Protecao.item.glow")).build();
                t.getInventory().addItem(mochila);
                sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Gived").replace("&", "§"));
            } else if(args[1].equalsIgnoreCase("ferramentas")){
                ItemStack mochila = new MakeItem(Mochilas.getInstance().getConfig().getString("Ferramentas.item.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Ferramentas.item.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Ferramentas.item.lore"))
                        .addGlow(Mochilas.getInstance().getConfig().getBoolean("Ferramentas.item.glow")).build();
                t.getInventory().addItem(mochila);
                sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Gived").replace("&", "§"));
            } else if(args[1].equalsIgnoreCase("combate")){
                ItemStack mochila = new MakeItem(Mochilas.getInstance().getConfig().getString("Combate.item.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Combate.item.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Combate.item.lore"))
                        .addGlow(Mochilas.getInstance().getConfig().getBoolean("Combate.item.glow")).build();
                t.getInventory().addItem(mochila);
                sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Gived").replace("&", "§"));
            } else {
                sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Mochila_Not_Found").replace("&", "§"));
                return false;
            }
        }

        return false;
    }
}
