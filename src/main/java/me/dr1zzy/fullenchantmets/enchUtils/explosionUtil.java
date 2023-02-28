package me.dr1zzy.fullenchantmets.enchUtils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.*;

public class explosionUtil implements Listener {

    BlockFace blockFace = null;

    @EventHandler
    public void onClick(PlayerInteractEvent e){

        if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)){

            blockFace = e.getBlockFace();

        }


    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){

        Block block = e.getBlock();
        Material blockType = block.getType();
        List<Material> ablocks = new ArrayList<Material>();
        ablocks.add(STONE);
        ablocks.add(COBBLESTONE);
        ablocks.add(GRANITE);
        ablocks.add(POLISHED_GRANITE);
        ablocks.add(DIORITE);
        ablocks.add(POLISHED_DIORITE);
        ablocks.add(ANDESITE);
        ablocks.add(POLISHED_ANDESITE);
        ablocks.add(COAL_BLOCK);
        ablocks.add(IRON_BLOCK);
        ablocks.add(REDSTONE_BLOCK);
        ablocks.add(LAPIS_BLOCK);
        ablocks.add(GOLD_BLOCK);
        ablocks.add(DIAMOND_BLOCK);
        ablocks.add(EMERALD_BLOCK);
        ablocks.add(NETHERITE_BLOCK);
        ablocks.add(QUARTZ_BLOCK);
        ablocks.add(QUARTZ_BRICKS);
        ablocks.add(QUARTZ_PILLAR);
        ablocks.add(CHISELED_QUARTZ_BLOCK);
        ablocks.add(DARK_PRISMARINE);
        ablocks.add(PRISMARINE);
        ablocks.add(PRISMARINE_BRICKS);
        ablocks.add(WHITE_TERRACOTTA);
        ablocks.add(ORANGE_TERRACOTTA);
        ablocks.add(MAGENTA_TERRACOTTA);
        ablocks.add(LIGHT_BLUE_TERRACOTTA);
        ablocks.add(YELLOW_TERRACOTTA);
        ablocks.add(LIME_TERRACOTTA);
        ablocks.add(PINK_TERRACOTTA);
        ablocks.add(GRAY_TERRACOTTA);
        ablocks.add(LIGHT_GRAY_TERRACOTTA);
        ablocks.add(CYAN_TERRACOTTA);
        ablocks.add(PURPLE_TERRACOTTA);
        ablocks.add(BLUE_TERRACOTTA);
        ablocks.add(BROWN_TERRACOTTA);
        ablocks.add(GREEN_TERRACOTTA);
        ablocks.add(RED_TERRACOTTA);
        ablocks.add(BLACK_TERRACOTTA);
        ablocks.add(TERRACOTTA);
        ablocks.add(WHITE_CONCRETE);
        ablocks.add(ORANGE_CONCRETE);
        ablocks.add(MAGENTA_CONCRETE);
        ablocks.add(LIGHT_BLUE_CONCRETE);
        ablocks.add(YELLOW_CONCRETE);
        ablocks.add(LIME_CONCRETE);
        ablocks.add(PINK_CONCRETE);
        ablocks.add(GRAY_CONCRETE);
        ablocks.add(LIGHT_GRAY_CONCRETE);
        ablocks.add(CYAN_CONCRETE);
        ablocks.add(PURPLE_CONCRETE);
        ablocks.add(BLUE_CONCRETE);
        ablocks.add(BROWN_CONCRETE);
        ablocks.add(GREEN_CONCRETE);
        ablocks.add(RED_CONCRETE);
        ablocks.add(BLACK_CONCRETE);

        if(ablocks.contains(block.getType())){
            if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.RED + "Explosion")){

                if(blockFace.equals(BlockFace.UP) || blockFace.equals(BlockFace.DOWN)){
                    Block block1 = block.getRelative(BlockFace.EAST);
                    Block block2 = block.getRelative(BlockFace.WEST);
                    Block block3 = block.getRelative(BlockFace.NORTH);
                    Block block4 = block.getRelative(BlockFace.SOUTH);
                    Block block5 = block.getRelative(BlockFace.SOUTH_WEST);
                    Block block6 = block.getRelative(BlockFace.SOUTH_EAST);
                    Block block7 = block.getRelative(BlockFace.NORTH_WEST);
                    Block block8 = block.getRelative(BlockFace.NORTH_EAST);

                    block1.setType(Material.AIR);
                    block2.setType(Material.AIR);
                    block3.setType(Material.AIR);
                    block4.setType(Material.AIR);
                    block5.setType(Material.AIR);
                    block6.setType(Material.AIR);
                    block7.setType(Material.AIR);
                    block8.setType(Material.AIR);

                    block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(blockType));


                    e.getPlayer().spawnParticle(Particle.CLOUD, block.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block1.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block2.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block3.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block4.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block5.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block6.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block7.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block8.getLocation(), 10);

                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_TNT_PRIMED, 2, 10);


                }
                if(blockFace.equals(BlockFace.EAST) || blockFace.equals(BlockFace.WEST)){
                    Block block1 = block.getRelative(BlockFace.UP);
                    Block block2 = block.getRelative(BlockFace.DOWN);
                    Block block3 = block.getRelative(BlockFace.NORTH);
                    Block block4 = block.getRelative(BlockFace.SOUTH);
                    Block block5 = block1.getRelative(BlockFace.NORTH);
                    Block block6 = block1.getRelative(BlockFace.SOUTH);
                    Block block7 = block2.getRelative(BlockFace.NORTH);
                    Block block8 = block2.getRelative(BlockFace.SOUTH);

                    block1.setType(Material.AIR);
                    block2.setType(Material.AIR);
                    block3.setType(Material.AIR);
                    block4.setType(Material.AIR);
                    block5.setType(Material.AIR);
                    block6.setType(Material.AIR);
                    block7.setType(Material.AIR);
                    block8.setType(Material.AIR);

                    block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(blockType));

                    e.getPlayer().spawnParticle(Particle.CLOUD, block.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block1.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block2.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block3.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block4.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block5.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block6.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block7.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block8.getLocation(), 10);

                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_TNT_PRIMED, 2, 10);
                }
                if(blockFace.equals(BlockFace.NORTH) || blockFace.equals(BlockFace.SOUTH)){
                    Block block1 = block.getRelative(BlockFace.UP);
                    Block block2 = block.getRelative(BlockFace.DOWN);
                    Block block3 = block.getRelative(BlockFace.EAST);
                    Block block4 = block.getRelative(BlockFace.WEST);
                    Block block5 = block1.getRelative(BlockFace.EAST);
                    Block block6 = block1.getRelative(BlockFace.WEST);
                    Block block7 = block2.getRelative(BlockFace.EAST);
                    Block block8 = block2.getRelative(BlockFace.WEST);

                    block1.setType(Material.AIR);
                    block2.setType(Material.AIR);
                    block3.setType(Material.AIR);
                    block4.setType(Material.AIR);
                    block5.setType(Material.AIR);
                    block6.setType(Material.AIR);
                    block7.setType(Material.AIR);
                    block8.setType(Material.AIR);

                    block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(blockType));
                    block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(blockType));

                    e.getPlayer().spawnParticle(Particle.CLOUD, block.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block1.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block2.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block3.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block4.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block5.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block6.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block7.getLocation(), 10);
                    e.getPlayer().spawnParticle(Particle.CLOUD, block8.getLocation(), 10);

                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_TNT_PRIMED, 2, 10);
                }


            }
        }

    }



}
