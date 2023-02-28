package me.dr1zzy.fullenchantmets.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class enchantSetEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        ItemStack book = e.getCursor();


        if(e.getClickedInventory().equals(p.getInventory())){
            List<Material> pickaxes = new ArrayList<Material>();
            pickaxes.add(Material.WOODEN_PICKAXE);
            pickaxes.add(Material.STONE_PICKAXE);
            pickaxes.add(Material.IRON_PICKAXE);
            pickaxes.add(Material.GOLDEN_PICKAXE);
            pickaxes.add(Material.DIAMOND_PICKAXE);
            pickaxes.add(Material.NETHERITE_PICKAXE);

            //explosion
            ItemStack explosionBook = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta explosionBookMeta = explosionBook.getItemMeta();
            explosionBookMeta.setDisplayName(ChatColor.RED + "Explosion");
            List<String> explosionBookLore = new ArrayList<>();
            explosionBookLore.add("");
            explosionBookLore.add(ChatColor.GRAY + "Este encantamiento te permite");
            explosionBookLore.add(ChatColor.GRAY + "minar un area de 3 bloques de");
            explosionBookLore.add(ChatColor.GRAY + "piedra.");
            explosionBookMeta.setLore(explosionBookLore);
            explosionBook.setItemMeta(explosionBookMeta);

            //midas
            ItemStack midasBook = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta midasBookMeta = midasBook.getItemMeta();
            midasBookMeta.setDisplayName(ChatColor.GOLD + "MIDAS");
            List<String> midasBookLore = new ArrayList<>();
            midasBookLore.add("");
            midasBookLore.add(ChatColor.GRAY + "Cuando mines cualquier mineral");
            midasBookLore.add(ChatColor.GRAY + "este se convertira instantaneamente");
            midasBookLore.add(ChatColor.GRAY + "en oro.");
            midasBookMeta.setLore(midasBookLore);
            midasBook.setItemMeta(midasBookMeta);

            //smelt
            ItemStack smeltBook = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta smeltBookMeta = smeltBook.getItemMeta();
            smeltBookMeta.setDisplayName(ChatColor.YELLOW + "SMELT");
            List<String> smeltBookLore = new ArrayList<>();
            smeltBookLore.add("");
            smeltBookLore.add(ChatColor.GRAY + "Cuando mines un bloque");
            smeltBookLore.add(ChatColor.GRAY + "este se cocinara automaticamente.");
            smeltBookMeta.setLore(smeltBookLore);
            smeltBook.setItemMeta(smeltBookMeta);

            if(pickaxes.contains(item.getType())){
                if(book.equals(explosionBook)){
                    List oldLore = new ArrayList<>();
                    oldLore.add(item.getItemMeta().getLore());
                    List newLore = new ArrayList<>();
                    newLore.add(oldLore);
                    newLore.add(ChatColor.RED + "Expplosion");
                    item.getItemMeta().setLore(newLore);
                }
                if(book.equals(smeltBook)){

                }
                if(book.equals(midasBook)){

                }
            }
        }
    }

}
