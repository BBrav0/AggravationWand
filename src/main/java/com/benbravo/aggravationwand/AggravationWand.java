package com.benbravo.aggravationwand;

import org.bukkit.plugin.java.JavaPlugin;

public class AggravationWand extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("AggravationWand has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AggravationWand has been disabled!");
    }
}
