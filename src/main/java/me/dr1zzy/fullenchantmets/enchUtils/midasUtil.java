package me.dr1zzy.fullenchantmets.enchUtils;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class midasUtil implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        Material blockType = e.getBlock().getType();
        Block block = e.getBlock();
        List<Material> blocks = new ArrayList<Material>();
        blocks.add(Material.COAL_ORE);
        blocks.add(Material.IRON_ORE);
        blocks.add(Material.REDSTONE_ORE);
        blocks.add(Material.LAPIS_ORE);
        blocks.add(Material.GOLD_ORE);
        blocks.add(Material.DIAMOND_ORE);
        blocks.add(Material.EMERALD_ORE);

        ItemStack gold = new ItemStack(Material.GOLD_BLOCK);

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
                    if(blocks.contains(e.getBlock().getType())){
                        block.setType(Material.AIR);
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_INGOT));
                    }
                }
            }
        }else {
            e.setCancelled(false);
        }



    }

}
