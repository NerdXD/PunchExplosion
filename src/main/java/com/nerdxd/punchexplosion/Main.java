package com.nerdxd.punchexplosion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("PunchExplosion Plugin is now activated...");
        getCommand("PunchExplosion").setExecutor(new PunchExplosionCommand());
        Bukkit.getPluginManager().registerEvents(new PunchExplosionCommand(), this);

    }

}
