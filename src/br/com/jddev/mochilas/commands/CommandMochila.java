package br.com.jddev.mochilas.commands;

import br.com.jddev.mochilas.Mochilas;
import br.com.jddev.mochilas.utils.Serializer;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CommandMochila implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)){
            return false;
        }

        if(!sender.hasPermission("jdmochilas.admin")){
            sender.sendMessage(Mochilas.getInstance().getConfig().getString("Messages.No_Perm").replace("&", "§"));
            return false;
        }

        Player p = (Player) sender;

        if(args.length == 0){
            sender.sendMessage("§cUtilize: /mochila set <invasao/protecao/ferramentas/combate>.");
            return false;
        }

        if(args.length == 1){
            sender.sendMessage("§cUtilize: /mochila set <invasao/protecao/ferramentas/combate>.");
            return false;
        }

        if(args.length == 2){
            if(args[1].equalsIgnoreCase("invasao")){
                ArrayList<String> items = new ArrayList<>();
                for (ItemStack i : p.getInventory().getContents()) {
                    if (i != null && i.getType() != Material.AIR)
                        items.add(Serializer.serializeItemStack(i));
                }
                Mochilas.getInstance().getConfig().set("Invasao.itens", items);
                Mochilas.getInstance().saveConfig();
                p.sendMessage("§aMochila salva com sucesso!");
            } else if(args[1].equalsIgnoreCase("protecao")){
                ArrayList<String> items = new ArrayList<>();
                for (ItemStack i : p.getInventory().getContents()) {
                    if (i != null && i.getType() != Material.AIR)
                        items.add(Serializer.serializeItemStack(i));
                }
                Mochilas.getInstance().getConfig().set("Protecao.itens", items);
                Mochilas.getInstance().saveConfig();
                p.sendMessage("§aMochila salva com sucesso!");
            } else if(args[1].equalsIgnoreCase("ferramentas")){
                ArrayList<String> items = new ArrayList<>();
                for (ItemStack i : p.getInventory().getContents()) {
                    if (i != null && i.getType() != Material.AIR)
                        items.add(Serializer.serializeItemStack(i));
                }
                Mochilas.getInstance().getConfig().set("Ferramentas.itens", items);
                Mochilas.getInstance().saveConfig();
                p.sendMessage("§aMochila salva com sucesso!");
            } else if(args[1].equalsIgnoreCase("combate")){
                ArrayList<String> items = new ArrayList<>();
                for (ItemStack i : p.getInventory().getContents()) {
                    if (i != null && i.getType() != Material.AIR)
                        items.add(Serializer.serializeItemStack(i));
                }
                Mochilas.getInstance().getConfig().set("Combate.itens", items);
                Mochilas.getInstance().saveConfig();
                p.sendMessage("§aMochila salva com sucesso!");
            } else {
                sender.sendMessage("§cUtilize: /mochila set <invasao/protecao/ferramentas/combate>.");
            }
        }

        return false;
    }
}
