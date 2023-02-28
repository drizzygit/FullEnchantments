package me.dr1zzy.fullenchantmets.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class tinkerCommand implements CommandExecutor {
    Inventory inv;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(p.hasPermission("fullenchs.tinker")){
            inv = Bukkit.createInventory(p, 27, ChatColor.GREEN + "TINKER");
            p.openInventory(inv);

        }

        return true;
    }
}
