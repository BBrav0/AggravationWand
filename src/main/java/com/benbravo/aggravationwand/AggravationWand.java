package com.benbravo.aggravationwand;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;

public class AggravationWand extends JavaPlugin {
    
    private ItemStack wand;
    public static final String WAND_NAME = "Aggravation Wand";
    
    @Override
    public void onEnable() {
        // Create the wand item
        wand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = wand.getItemMeta();
        meta.displayName(Component.text(WAND_NAME));
        wand.setItemMeta(meta);
        
        getServer().getPluginManager().registerEvents(new WandListener(this), this);
        getLogger().info("AggravationWand has been enabled!");
    }
    
    public ItemStack getWand() {
        return wand;
    }

    @Override
    public void onDisable() {
        getLogger().info("AggravationWand has been disabled!");
    }

}
