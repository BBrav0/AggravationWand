package com.benbravo.aggravationwand;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class WandListener implements Listener {
    private final AggravationWand plugin;
    private static final int MAX_RANGE = 50; // blocks

    public WandListener(AggravationWand plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Only trigger on right-click
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        
        Player p = event.getPlayer();
        ItemStack heldItem = p.getInventory().getItemInMainHand();
        
        if (isWand(heldItem)) {
            // Raycast to find entity player is looking at
            Entity target = p.getTargetEntity(MAX_RANGE);
            
            if (target instanceof Mob mob) {
                // Make the mob target the player
                mob.setTarget(p);
                p.sendMessage("Aggravated " + mob.getType().name());
            }
        }
    }
    
    private boolean isWand(ItemStack item) {
        if (item == null || item.getType() != Material.BLAZE_ROD) {
            return false;
        }
        
        ItemMeta meta = item.getItemMeta();
        if (meta == null || !meta.hasDisplayName()) {
            return false;
        }
        
        Component displayName = meta.displayName();
        String name = PlainTextComponentSerializer.plainText().serialize(displayName);
        return name.equals(AggravationWand.WAND_NAME);
    }
}
