package me.dr1zzy.fullenchantmets.enchUtils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class smeltUtil implements Listener {

    Material itemToDrop;

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        Material blockType = e.getBlock().getType();
        Block block = e.getBlock();

        List<Material> pickaxes = new ArrayList<Material>();
        pickaxes.add(Material.WOODEN_PICKAXE);
        pickaxes.add(Material.STONE_PICKAXE);
        pickaxes.add(Material.IRON_PICKAXE);
        pickaxes.add(Material.GOLDEN_PICKAXE);
        pickaxes.add(Material.DIAMOND_PICKAXE);
        pickaxes.add(Material.NETHERITE_PICKAXE);

        if(pickaxes.contains(p.getInventory().getItemInMainHand().getType())){
            if(p.getInventory().getItemInMainHand().getItemMeta().hasLore()){

                if(p.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.GOLD + "Midas")){
                    if (blockType.equals(Material.IRON_ORE)) {
                        block.setType(Material.AIR);

                        block.getWorld().dropItemNaturally(block.getLocation().add(0, +1, 0), new ItemStack(Material.IRON_INGOT));
                        p.playSound(p.getLocation(), Sound.BLOCK_FURNACE_FIRE_CRACKLE, 2, 1);
                    }
                    if (blockType.equals(Material.GOLD_ORE)) {
                        block.setType(Material.AIR);

                        block.getWorld().dropItemNaturally(block.getLocation().add(0, +1, 0), new ItemStack(Material.GOLD_INGOT));
                        p.playSound(p.getLocation(), Sound.BLOCK_FURNACE_FIRE_CRACKLE, 2, 1);
                    }
                    if (blockType.equals(Material.COBBLESTONE)) {
                        block.setType(Material.AIR);

                        block.getWorld().dropItemNaturally(block.getLocation().add(0, +1, 0), new ItemStack(Material.STONE));
                        p.playSound(p.getLocation(), Sound.BLOCK_FURNACE_FIRE_CRACKLE, 2, 1);
                    }
                    if (blockType.equals(Material.STONE)) {
                        block.setType(Material.AIR);

                        block.getWorld().dropItemNaturally(block.getLocation().add(0, +1, 0), new ItemStack(Material.SMOOTH_STONE));
                        p.playSound(p.getLocation(), Sound.BLOCK_FURNACE_FIRE_CRACKLE, 2, 1);
                    }
                }
            }
        }else {
           e.setCancelled(false);
        }


    }

}
