package me.dr1zzy.fullenchantmets;

import me.dr1zzy.fullenchantmets.commands.mainCmd;
import me.dr1zzy.fullenchantmets.commands.tinkerCommand;
import me.dr1zzy.fullenchantmets.enchUtils.explosionUtil;
import me.dr1zzy.fullenchantmets.enchUtils.midasUtil;
import me.dr1zzy.fullenchantmets.enchUtils.smeltUtil;
import me.dr1zzy.fullenchantmets.events.enchantSetEvent;
import me.dr1zzy.fullenchantmets.menus.tinkerMenu;
import me.dr1zzy.fullenchantmets.menusManager.tinkerMenuManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class FullEnchantmets extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        //commands
        getCommand("fe").setExecutor(new mainCmd());
        getCommand("tinker").setExecutor(new tinkerCommand());

        //enchantmentsUtils
        getServer().getPluginManager().registerEvents(new explosionUtil(), this);
        getServer().getPluginManager().registerEvents(new midasUtil(), this);
        getServer().getPluginManager().registerEvents(new smeltUtil(), this);

        //events
        getServer().getPluginManager().registerEvents(new enchantSetEvent(), this);

        //menus
        getServer().getPluginManager().registerEvents(new tinkerMenu(), this);

        //menusManager
        getServer().getPluginManager().registerEvents(new tinkerMenuManager(), this);


    }

}
