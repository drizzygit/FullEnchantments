package me.dr1zzy.fullenchantmets.commands;

import me.dr1zzy.fullenchantmets.FullEnchantmets;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mainCmd implements CommandExecutor {

    File enchantersFile = new File(FullEnchantmets.getPlugin(FullEnchantmets.class).getDataFolder() + "enchanters.yml");
    File getEnchantersFile;
    FileConfiguration getEnchantersFileConfig;

    ItemStack item;
    ItemMeta itemMeta;
    List<String> itemLore;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        List<String> enchList = new ArrayList<String>();
        enchList.add("explosion");
        enchList.add("smelt");
        enchList.add("midas");

        List<Material> pickaxes = new ArrayList<Material>();
        pickaxes.add(Material.WOODEN_PICKAXE);
        pickaxes.add(Material.STONE_PICKAXE);
        pickaxes.add(Material.IRON_PICKAXE);
        pickaxes.add(Material.GOLDEN_PICKAXE);
        pickaxes.add(Material.DIAMOND_PICKAXE);
        pickaxes.add(Material.NETHERITE_PICKAXE);

        List<String> enchants = new ArrayList<>();
        enchants.add("explosion");
        enchants.add("smelt");
        enchants.add("midas");

        Player p = (Player) sender;
        List<String> itemLore;
        List<String> currentLore;

        if (args.length == 0) {
            p.sendMessage(ChatColor.RED + "Por favor usa /he help");
        }

        if (args[0].equalsIgnoreCase("enchant")) {
            Material inHandItem = p.getInventory().getItemInMainHand().getType();
            if (args[1].length() == 0) {
                p.sendMessage(ChatColor.RED + "Debes mencionar un encantamiento valido!");
            } else {
                String enchant = args[1];
                if (!enchList.contains(enchant)) {
                    p.sendMessage(ChatColor.RED + "Este encantamiento no existe!");
                } else {
                    if (enchant.equalsIgnoreCase("explosion")) {

                        if (pickaxes.contains(inHandItem)) {

                            if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {


                                currentLore = p.getInventory().getItemInMainHand().getItemMeta().getLore();
                                if (currentLore.contains(ChatColor.RED + "Explosion")) {
                                    p.sendMessage(ChatColor.RED + "Este pico ya contiene EXPLOSION.");
                                } else {
                                    ItemStack pickaxe = p.getEquipment().getItemInMainHand();
                                    ItemMeta pickaxem = pickaxe.getItemMeta();
                                    itemLore = p.getInventory().getItemInMainHand().getItemMeta().getLore();
                                    itemLore.add(ChatColor.RED + "Explosion");
                                    pickaxem.setLore(itemLore);
                                    pickaxe.setItemMeta(pickaxem);

                                    p.getEquipment().getItemInMainHand().setItemMeta(pickaxem);
                                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 29);
                                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "FULL ENCHS " + ChatColor.DARK_GRAY + "» " + ChatColor.GREEN + "Has colocado correctamente EXPLOSION en este item.");
                                    p.spawnParticle(Particle.FLAME, p.getLocation(), 20);
                                }
                            } else if (!p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                                ItemStack pickaxe = p.getEquipment().getItemInMainHand();
                                ItemMeta pickaxem = pickaxe.getItemMeta();
                                List newLore = new ArrayList<String>();
                                newLore.add(ChatColor.RED + "Explosion");
                                pickaxem.setLore(newLore);
                                pickaxe.setItemMeta(pickaxem);

                                p.getEquipment().getItemInMainHand().setItemMeta(pickaxem);
                                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 29);
                                p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "FULL ENCHS " + ChatColor.DARK_GRAY + "» " + ChatColor.GREEN + "Has colocado correctamente EXPLOSION en este item.");
                                p.spawnParticle(Particle.FLAME, p.getLocation(), 20);
                            }


                        } else {
                            p.sendMessage(ChatColor.RED + "Este encantamiento solo funciona en picos!");
                        }


                    }

                    if (enchant.equalsIgnoreCase("smelt")) {
                        if (pickaxes.contains(inHandItem)) {

                            if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                                currentLore = p.getInventory().getItemInMainHand().getItemMeta().getLore();
                                if (currentLore.contains(ChatColor.YELLOW + "Smelt")) {
                                    p.sendMessage(ChatColor.RED + "Este pico ya contiene SMELT");
                                } else {
                                    ItemStack pickaxe = p.getEquipment().getItemInMainHand();
                                    ItemMeta pickaxem = pickaxe.getItemMeta();
                                    itemLore = p.getInventory().getItemInMainHand().getItemMeta().getLore();
                                    itemLore.add(ChatColor.YELLOW + "Smelt");
                                    pickaxem.setLore(itemLore);
                                    pickaxe.setItemMeta(pickaxem);

                                    p.getEquipment().getItemInMainHand().setItemMeta(pickaxem);
                                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 29);
                                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "FULL ENCHS " + ChatColor.DARK_GRAY + "» " + ChatColor.GREEN + "Has colocado correctamente SMELT en este item.");
                                    p.spawnParticle(Particle.FLAME, p.getLocation(), 20);
                                }


                            } else if (!p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {

                                ItemStack pickaxe = p.getEquipment().getItemInMainHand();
                                ItemMeta pickaxem = pickaxe.getItemMeta();
                                List newLore = new ArrayList<String>();
                                newLore.add(ChatColor.YELLOW + "Smelt");
                                pickaxem.setLore(newLore);

                                pickaxe.setItemMeta(pickaxem);

                                p.getEquipment().getItemInMainHand().setItemMeta(pickaxem);
                                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 29);
                                p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "FULL ENCHS " + ChatColor.DARK_GRAY + "» " + ChatColor.GREEN + "Has colocado correctamente SMELT en este item.");
                                p.spawnParticle(Particle.FLAME, p.getLocation(), 20);

                            }

                        } else {
                            p.sendMessage(ChatColor.RED + "Este encantamiento solo funciona en picos!");
                        }

                    }
                    if (enchant.equalsIgnoreCase("midas")) {
                        if (pickaxes.contains(inHandItem)) {

                            if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                                currentLore = p.getInventory().getItemInMainHand().getItemMeta().getLore();
                                if (currentLore.contains(ChatColor.GOLD + "Midas")) {
                                    p.sendMessage(ChatColor.RED + "Este pico ya contiene MIDAS");
                                } else {
                                    ItemStack pickaxe = p.getEquipment().getItemInMainHand();
                                    ItemMeta pickaxem = pickaxe.getItemMeta();
                                    itemLore = p.getInventory().getItemInMainHand().getItemMeta().getLore();
                                    itemLore.add(ChatColor.GOLD + "Midas");
                                    pickaxem.setLore(itemLore);
                                    pickaxe.setItemMeta(pickaxem);

                                    p.getEquipment().getItemInMainHand().setItemMeta(pickaxem);
                                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 29);
                                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "FULL ENCHS " + ChatColor.DARK_GRAY + "» " + ChatColor.GREEN + "Has colocado correctamente MIDAS en este item.");
                                    p.spawnParticle(Particle.FLAME, p.getLocation(), 20);
                                }


                            } else if (!p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {

                                ItemStack pickaxe = p.getEquipment().getItemInMainHand();
                                ItemMeta pickaxem = pickaxe.getItemMeta();
                                List newLore = new ArrayList<String>();
                                newLore.add(ChatColor.GOLD + "Midas");
                                pickaxem.setLore(newLore);

                                pickaxe.setItemMeta(pickaxem);

                                p.getEquipment().getItemInMainHand().setItemMeta(pickaxem);
                                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 29);
                                p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "FULL ENCHS " + ChatColor.DARK_GRAY + "» " + ChatColor.GREEN + "Has colocado correctamente MIDAS en este item.");
                                p.spawnParticle(Particle.FLAME, p.getLocation(), 20);

                            }

                        } else {
                            p.sendMessage(ChatColor.RED + "Este encantamiento solo funciona en picos!");
                        }

                    }

                }
            }

        } else if (args[0].equalsIgnoreCase("give")) {
            if(args.length == 2){
                p.sendMessage(ChatColor.RED + "Usa el comando: /fe give <player> <enchantment>");
            }else {
                Player target = Bukkit.getPlayerExact(args[1]);
                if(target.isOnline()){
                    if(enchants.contains(args[2])){
                        if(args[2].equalsIgnoreCase("explosion")){
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

                            p.getInventory().addItem(explosionBook);

                        }
                        if(args[2].equalsIgnoreCase("midas")){
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

                            p.getInventory().addItem(midasBook);
                        }
                        if(args[2].equalsIgnoreCase("smelt")){
                            ItemStack smeltBook = new ItemStack(Material.ENCHANTED_BOOK);
                            ItemMeta smeltBookMeta = smeltBook.getItemMeta();
                            smeltBookMeta.setDisplayName(ChatColor.YELLOW + "SMELT");
                            List<String> smeltBookLore = new ArrayList<>();
                            smeltBookLore.add("");
                            smeltBookLore.add(ChatColor.GRAY + "Cuando mines un bloque");
                            smeltBookLore.add(ChatColor.GRAY + "este se cocinara automaticamente.");
                            smeltBookMeta.setLore(smeltBookLore);
                            smeltBook.setItemMeta(smeltBookMeta);

                            p.getInventory().addItem(smeltBook);
                        }
                    }else {
                        p.sendMessage(ChatColor.RED + "Encantamiento invalido");
                    }
                }else {
                    p.sendMessage(ChatColor.RED + "Jugador invalido");
                }
            }
        }
        return true;
        }

}
