package br.com.jddev.mochilas.listeners;

import br.com.jddev.mochilas.Mochilas;
import br.com.jddev.mochilas.utils.MakeItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ListenerPlayerInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();

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

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(p.getItemInHand().isSimilar(invasao)){

                Inventory inv = Bukkit.createInventory(null, 3*9, "§7Invasão Confirmação:");

                ItemStack sim = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.confirmar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.confirmar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.confirmar.lore")).build();

                ItemStack nao = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.cancelar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.cancelar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.cancelar.lore")).build();

                inv.setItem(11, sim);
                inv.setItem(13, invasao);
                inv.setItem(15, nao);

                p.openInventory(inv);

            } else if(p.getItemInHand().isSimilar(protecao)){

                Inventory inv = Bukkit.createInventory(null, 3*9, "§7Proteção Confirmação:");

                ItemStack sim = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.confirmar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.confirmar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.confirmar.lore")).build();

                ItemStack nao = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.cancelar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.cancelar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.cancelar.lore")).build();

                inv.setItem(11, sim);
                inv.setItem(13, protecao);
                inv.setItem(15, nao);

                p.openInventory(inv);

            } else if(p.getItemInHand().isSimilar(ferramentas)){

                Inventory inv = Bukkit.createInventory(null, 3*9, "§7Ferramentas Confirmação:");

                ItemStack sim = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.confirmar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.confirmar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.confirmar.lore")).build();

                ItemStack nao = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.cancelar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.cancelar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.cancelar.lore")).build();

                inv.setItem(11, sim);
                inv.setItem(13, ferramentas);
                inv.setItem(15, nao);

                p.openInventory(inv);

            } else if(p.getItemInHand().isSimilar(combate)){

                Inventory inv = Bukkit.createInventory(null, 3*9, "§7Combate Confirmação:");

                ItemStack sim = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.confirmar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.confirmar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.confirmar.lore")).build();

                ItemStack nao = new MakeItem(Mochilas.getInstance().getConfig().getString("Itens.cancelar.id"))
                        .setName(Mochilas.getInstance().getConfig().getString("Itens.cancelar.name"))
                        .addLore((ArrayList<String>)Mochilas.getInstance().getConfig().getStringList("Itens.cancelar.lore")).build();

                inv.setItem(11, sim);
                inv.setItem(13, combate);
                inv.setItem(15, nao);

                p.openInventory(inv);

            }
        }

    }

}
