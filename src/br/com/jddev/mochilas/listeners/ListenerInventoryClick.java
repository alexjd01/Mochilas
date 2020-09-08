package br.com.jddev.mochilas.listeners;

import br.com.jddev.mochilas.Mochilas;
import br.com.jddev.mochilas.utils.InventoryAPI;
import br.com.jddev.mochilas.utils.MakeItem;
import br.com.jddev.mochilas.utils.Serializer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ListenerInventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        ItemStack invasao = new MakeItem(Mochilas.getInstance().getConfig().getString("Invasao.item.id"))
                .setName(Mochilas.getInstance().getConfig().getString("Invasao.item.name"))
                .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Invasao.item.lore"))
                .addGlow(Mochilas.getInstance().getConfig().getBoolean("Invasao.item.glow")).build();

        ItemStack protecao = new MakeItem(Mochilas.getInstance().getConfig().getString("Protecao.item.id"))
                .setName(Mochilas.getInstance().getConfig().getString("Protecao.item.name"))
                .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Protecao.item.lore"))
                .addGlow(Mochilas.getInstance().getConfig().getBoolean("Protecao.item.glow")).build();

        ItemStack ferramentas = new MakeItem(Mochilas.getInstance().getConfig().getString("Ferramentas.item.id"))
                .setName(Mochilas.getInstance().getConfig().getString("Ferramentas.item.name"))
                .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Ferramentas.item.lore"))
                .addGlow(Mochilas.getInstance().getConfig().getBoolean("Ferramentas.item.glow")).build();

        ItemStack combate = new MakeItem(Mochilas.getInstance().getConfig().getString("Combate.item.id"))
                .setName(Mochilas.getInstance().getConfig().getString("Combate.item.name"))
                .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Combate.item.lore"))
                .addGlow(Mochilas.getInstance().getConfig().getBoolean("Combate.item.glow")).build();

        if(e.getInventory().getName().equalsIgnoreCase("§7Invasão confirmação:")){
            e.setCancelled(true);
            if(e.getSlot() == 11){
                if(p.getItemInHand().isSimilar(invasao)){
                    if(InventoryAPI.checkIsFull(p)){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Inventory_Full").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    ArrayList<String> itens = (ArrayList<String>) Mochilas.getInstance().getConfig().getStringList("Invasao.itens");
                    if(getFreeSpaceInInventory(p) < itens.size()){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.No_Space").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    if(p.getItemInHand().getAmount() == 1) {
                        p.setItemInHand(null);
                        p.updateInventory();
                    } else {
                        p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                    }
                    for (String x : itens) {
                        InventoryAPI.GiveItemPlayer(p, Serializer.deserializeItemStack(x));
                    }
                    p.closeInventory();
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Sucess").replace("&", "§"));
                } else {
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Mochila_Need").replace("&", "§"));
                    p.closeInventory();
                }
            }
        }

        if(e.getInventory().getName().equalsIgnoreCase("§7Proteção confirmação:")){
            e.setCancelled(true);
            if(e.getSlot() == 11){
                if(p.getItemInHand().isSimilar(protecao)){
                    if(InventoryAPI.checkIsFull(p)){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Inventory_Full").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    ArrayList<String> itens = (ArrayList<String>) Mochilas.getInstance().getConfig().getStringList("Protecao.itens");
                    if(getFreeSpaceInInventory(p) < itens.size()){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.No_Space").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    if(p.getItemInHand().getAmount() == 1) {
                        p.setItemInHand(null);
                        p.updateInventory();
                    } else {
                        p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                    }
                    for (String x : itens) {
                        InventoryAPI.GiveItemPlayer(p, Serializer.deserializeItemStack(x));
                    }
                    p.closeInventory();
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Sucess").replace("&", "§"));
                } else {
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Mochila_Need").replace("&", "§"));
                    p.closeInventory();
                }
            }
        }

        if(e.getInventory().getName().equalsIgnoreCase("§7Ferramentas confirmação:")){
            e.setCancelled(true);
            if(e.getSlot() == 11){
                if(p.getItemInHand().isSimilar(ferramentas)){
                    if(InventoryAPI.checkIsFull(p)){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Inventory_Full").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    ArrayList<String> itens = (ArrayList<String>) Mochilas.getInstance().getConfig().getStringList("Ferramentas.itens");
                    if(getFreeSpaceInInventory(p) < itens.size()){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.No_Space").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    if(p.getItemInHand().getAmount() == 1) {
                        p.setItemInHand(null);
                        p.updateInventory();
                    } else {
                        p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                    }
                    for (String x : itens) {
                        InventoryAPI.GiveItemPlayer(p, Serializer.deserializeItemStack(x));
                    }
                    p.closeInventory();
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Sucess").replace("&", "§"));
                } else {
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Mochila_Need").replace("&", "§"));
                    p.closeInventory();
                }
            }
        }

        if(e.getInventory().getName().equalsIgnoreCase("§7Combate confirmação:")){
            e.setCancelled(true);
            if(e.getSlot() == 11){
                if(p.getItemInHand().isSimilar(combate)){
                    if(InventoryAPI.checkIsFull(p)){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Inventory_Full").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    ArrayList<String> itens = (ArrayList<String>) Mochilas.getInstance().getConfig().getStringList("Combate.itens");
                    if(getFreeSpaceInInventory(p) < itens.size()){
                        p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.No_Space").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    if(p.getItemInHand().getAmount() == 1) {
                        p.setItemInHand(null);
                        p.updateInventory();
                    } else {
                        p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                    }
                    for (String x : itens) {
                        InventoryAPI.GiveItemPlayer(p, Serializer.deserializeItemStack(x));
                    }
                    p.closeInventory();
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Sucess").replace("&", "§"));
                } else {
                    p.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.Mochila_Need").replace("&", "§"));
                    p.closeInventory();
                }
            }
        }

    }

    private int getFreeSpaceInInventory(Player p) {
        int free = 0;
        ItemStack[] itens = p.getInventory().getContents();
        for (ItemStack item : itens) {
            if (item == null || item.getType() == Material.AIR) free++;
        }
        return free;
    }

}
