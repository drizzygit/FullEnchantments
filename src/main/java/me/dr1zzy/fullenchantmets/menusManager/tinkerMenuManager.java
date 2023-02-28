package me.dr1zzy.fullenchantmets.menusManager;

import com.sun.org.apache.xpath.internal.objects.XNull;
import me.dr1zzy.fullenchantmets.FullEnchantmets;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.net.ContentHandler;
import java.util.*;
import java.util.stream.Collector;

public class tinkerMenuManager implements Listener {

    ItemStack glass;
    ItemMeta glassMeta;

    ItemStack concrete;
    ItemMeta concreteMeta;
    List<String> concreteLore;

    ItemStack star;
    ItemMeta starMeta;
    List<String> starLore;

    BukkitTask task;

    @EventHandler
    public void onClick(InventoryClickEvent e) {

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

        Player p = (Player) e.getWhoClicked();
        String invTitle = e.getView().getTitle();
        ItemStack clickedItem = e.getCurrentItem();

        if (invTitle.equalsIgnoreCase(ChatColor.GREEN + "TINKER")) {

            if (!e.getInventory().equals(p.getInventory())) {

                if(e.getCurrentItem() == null){
                    e.setCancelled(false);
                }else {
                    if (clickedItem.equals(glass)) {
                        e.setCancelled(true);
                    }
                    if (clickedItem.equals(concrete)) {
                        e.setCancelled(true);
                        if (e.getView().getTopInventory().contains(Material.DIAMOND_BLOCK)){
                            e.getView().getTopInventory().remove(Material.DIAMOND_BLOCK);

                            Random random = new Random();
                            int chance = random.nextInt(100) + 1;

                            int oneStar = 1;   // %60
                            int twoStar = 2;   // %30
                            int treeStar = 3;  // %10

                            if (chance < 60) {
                                p.getInventory().addItem(new ItemStack(Material.NETHER_STAR, 1));
                            } else if (chance < 70) {
                                p.getInventory().addItem(new ItemStack(Material.NETHER_STAR, 3));
                            } else {
                                p.getInventory().addItem(new ItemStack(Material.NETHER_STAR, 2));
                            }
                        }
                    }
                    if (clickedItem.equals(star)) {
                        e.setCancelled(true);

                    }
                }

            }
            if (e.getClickedInventory().equals(p.getInventory())) {
                if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "TINKER")) {
                    if(e.getCurrentItem() == null){
                        e.setCancelled(false);
                    }else {
                        if (e.getClick().isLeftClick() || e.getClick().isRightClick() || e.getClick().isShiftClick() || e.getClick().isKeyboardClick() || e.getClick().isCreativeAction()) {
                            if (!clickedItem.getType().equals(Material.DIAMOND_BLOCK)) {
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }

    }

    @EventHandler
    public void onClose (InventoryCloseEvent e){
        HumanEntity p = e.getPlayer();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "TINKER")) {
            if (e.getView().getTopInventory().contains(Material.DIAMOND_BLOCK)) {

                if (!e.getView().getTopInventory().getItem(11).equals(null)) {
                    p.getInventory().addItem(e.getView().getTopInventory().getItem(11));
                }

            }
        }
    }
}
