package me.dr1zzy.fullenchantmets.menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class tinkerMenu implements Listener {
    ItemStack glass;
    ItemMeta glassMeta;

    ItemStack concrete;
    ItemMeta concreteMeta;
    List<String> concreteLore;

    ItemStack star;
    ItemMeta starMeta;
    List<String> starLore;

    @EventHandler
    public void onOpen(InventoryOpenEvent e){
        String invTitle = e.getView().getTitle();
        Inventory inv = e.getInventory();
        if(invTitle.equalsIgnoreCase(ChatColor.GREEN + "TINKER")){
            glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            glassMeta = glass.getItemMeta();
            glassMeta.setDisplayName("");
            glass.setItemMeta(glassMeta);

            concrete = new ItemStack(Material.LIME_CONCRETE);
            concreteMeta = concrete.getItemMeta();
            concreteMeta.setDisplayName(ChatColor.GREEN + "Confirmar tradeo");
            concreteLore = new ArrayList<String>();
            concreteLore.add("");
            concreteLore.add(ChatColor.GRAY + "Al aceptar el tradeo todos los");
            concreteLore.add(ChatColor.GRAY + "libros que esten dentro del tinker");
            concreteLore.add(ChatColor.GRAY + "desapareceran!");
            concreteMeta.setLore(concreteLore);
            concrete.setItemMeta(concreteMeta);

            star = new ItemStack(Material.NETHER_STAR);
            starMeta = star.getItemMeta();
            starMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Estrellas magicas");
            starLore = new ArrayList<String>();
            starLore.add("");
            starLore.add(ChatColor.GRAY + "Mientras mas libros especiales");
            starLore.add(ChatColor.GRAY + "coloques aqui ganaras mas estrellas");
            starLore.add(ChatColor.GRAY + "magicas.");
            starMeta.setLore(starLore);
            star.setItemMeta(starMeta);

            //itemsPositions

            //glass
            inv.setItem(0, glass);
            inv.setItem(1, glass);
            inv.setItem(2, glass);
            inv.setItem(3, glass);
            inv.setItem(4, glass);
            inv.setItem(5, glass);
            inv.setItem(6, glass);
            inv.setItem(7, glass);
            inv.setItem(8, glass);
            inv.setItem(9, glass);
            inv.setItem(10, glass);
            inv.setItem(12, glass);
            inv.setItem(14, glass);
            inv.setItem(16, glass);
            inv.setItem(17, glass);
            inv.setItem(18, glass);
            inv.setItem(19, glass);
            inv.setItem(20, glass);
            inv.setItem(21, glass);
            inv.setItem(22, glass);
            inv.setItem(23, glass);
            inv.setItem(24, glass);
            inv.setItem(25, glass);
            inv.setItem(26, glass);


            //concrete
            inv.setItem(15, concrete);

            //star
            inv.setItem(13, star);

        }

    }

}
