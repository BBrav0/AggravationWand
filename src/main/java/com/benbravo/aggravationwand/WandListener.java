package com.benbravo.aggravationwand;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class WandListener implements Listener {
    public ItemStack wand;
    private final AggravationWand plugin;

    public WandListener(AggravationWand plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        if (p.getInventory().getItemInMainHand().equals(wand)) {
            Entity e = event.getRightClicked();
        }
    }
}
