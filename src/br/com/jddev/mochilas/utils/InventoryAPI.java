package br.com.jddev.mochilas.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryAPI {

    public static boolean checkIsFull(org.bukkit.inventory.Inventory inv) {
        boolean hasEmptySlot = false;
        for (ItemStack stack : inv.getContents()) {
            if (stack == null) {
                hasEmptySlot = true;
                break;
            }
        }
        return !hasEmptySlot;
    }

    public static int getFreeSlot(Player p) {
        int i = 0;
        for (ItemStack stack : p.getInventory().getContents()) {
            if (stack == null) {
                i++;
            } else if (stack.getType() == Material.AIR) {
                i++;
            }
        }
        return i;
    }

    public static boolean checkIsClear(Player arg0) {
        for (ItemStack stack : arg0.getInventory().getContents()) {
            if (stack != null && !stack.getType().equals(Material.AIR)) {
                return false;
            }
        }
        for (ItemStack stack : arg0.getInventory().getArmorContents()) {
            if (stack != null && !stack.getType().equals(Material.AIR)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIsFull(Player arg0) {
        boolean hasEmptySlot = false;
        for (ItemStack stack : arg0.getInventory().getContents()) {
            if (stack == null) {
                hasEmptySlot = true;
                break;
            }
        }
        return !hasEmptySlot;
    }

    public static boolean hasSpace(Player arg0, int arg1) {
        int i = 0;
        for (ItemStack stack : arg0.getInventory().getContents()) {
            if (stack == null) {
                i++;
            }
            if (i >= arg1) {
                break;
            }
        }
        if (i >= arg1)
            return true;
        else
            return false;
    }

    public static boolean hasSpace(Player arg0, ItemStack item) {
        int i = 0;
        if (item == null)
            return false;
        for (ItemStack stack : arg0.getInventory().getContents()) {
            if (stack == null) {
                i++;
            }
        }
        if (i >= 0)
            return true;
        else
            return false;
    }

    public static boolean hasSpace(org.bukkit.inventory.Inventory arg0, int arg1) {
        int i = 0;
        for (ItemStack stack : arg0.getContents()) {
            if (stack == null) {
                i++;
            }
            if (i >= arg1) {
                break;
            }
        }
        if (i >= arg1)
            return true;
        else
            return false;
    }

    public static int getAmountItem(Player p, ItemStack ik) {
        int amount = 0;
        for (ItemStack ik1 : p.getInventory().getContents()) {
            if (ik1 != null)
                if (ik1.isSimilar(ik)) {
                    amount = amount + ik1.getAmount();
                }
        }
        return amount;
    }

    public static int getAmountItem(org.bukkit.inventory.Inventory i, ItemStack ik) {
        int amount = 0;
        for (ItemStack ik1 : i.getContents()) {
            if (ik1 != null)
                if (ik1.isSimilar(ik)) {
                    amount = amount + ik1.getAmount();
                }
        }
        return amount;
    }

    public static void debitItem(Player p, ItemStack arg1, int arg2) {
        ItemStack ik = arg1.clone();
        ik.setAmount(arg2);
        p.getInventory().removeItem(ik);
        p.updateInventory();
    }

    public static void debitItem(org.bukkit.inventory.Inventory i, ItemStack arg1, int arg2) {
        arg1.setAmount(arg2);
        i.removeItem(arg1);
    }

    public static boolean CheckIsInventory(InventoryClickEvent e, String name) {

        if (e.getInventory() == null) {
            return false;
        }

        if (!e.getInventory().getName().equalsIgnoreCase(name)) {
            return false;
        }

        e.setCancelled(true);
        if (e.getWhoClicked() instanceof Player) {
            ((Player) e.getWhoClicked()).updateInventory();
        }

        if (e.getClickedInventory() == null) {
            return false;
        }

        if (e.getCurrentItem() == null) {
            return false;
        }

        if (e.getClickedInventory().getName().equalsIgnoreCase(name)) {
            return true;
        }

        return false;
    }

    public static boolean checkIsAllowed(Player p, int int1) {
        for (ItemStack stack : p.getInventory().getContents()) {
            if (stack != null && !stack.getType().equals(Material.AIR)) {
                if (stack.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
                    if (stack.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > int1) {
                        return false;
                    }
                }
            }
        }
        for (ItemStack stack : p.getInventory().getArmorContents()) {
            if (stack != null && !stack.getType().equals(Material.AIR)) {
                if (stack.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
                    if (stack.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > int1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void GiveItemPlayer(Player p, ItemStack ik) {
        if (hasSpace(p, 1)) {
            p.getInventory().addItem(ik);
            p.updateInventory();
        } else {
            p.getWorld().dropItem(p.getLocation(), ik);
        }
    }

}
