package me.luckdeh.cosmeticsgui.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;

public class ParticleListener implements Listener {

    private Map<Player, Boolean> aquaParticleToggleMap = new HashMap<>();
    private Map<Player, Boolean> redstoneParticleToggleMap = new HashMap<>();
    private Map<Player, Boolean> crimsonSporeParticleToggleMap = new HashMap<>();
    private Map<Player, Boolean> purpleParticleToggleMap = new HashMap<>();
    private Map<Player, Boolean> blueParticleToggleMap = new HashMap<>();
    private Map<Player, Boolean> greenParticleToggleMap = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Cosmetics Menu")) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GREEN_DYE:
                    player.closeInventory();
                    toggleParticle(player, Particle.REDSTONE, greenParticleToggleMap);
                case LIGHT_BLUE_DYE:
                    player.closeInventory();
                    toggleParticle(player, Particle.REDSTONE, aquaParticleToggleMap);
                case BLUE_DYE:
                    player.closeInventory();
                    toggleParticle(player, Particle.REDSTONE, blueParticleToggleMap);
                case BLACK_DYE:
                    player.closeInventory();
                    toggleParticle(player, Particle.REDSTONE, redstoneParticleToggleMap);
                    break;
                case RED_DYE:
                    player.closeInventory();
                    toggleParticle(player, Particle.CRIMSON_SPORE, crimsonSporeParticleToggleMap);
                    break;
                case PURPLE_DYE:
                    player.closeInventory();
                    toggleParticle(player, Particle.REDSTONE, purpleParticleToggleMap);
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();



        if (aquaParticleToggleMap.getOrDefault(player, false)){
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.AQUA, 2.0F);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 1, dustOptions);
        }


        if (blueParticleToggleMap.getOrDefault(player, false)){
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLUE, 2.0F);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 1, dustOptions);
        }

        if (redstoneParticleToggleMap.getOrDefault(player, false)) {
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLACK, 2.0F);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 1, dustOptions);
        }

        if (crimsonSporeParticleToggleMap.getOrDefault(player, false)) {
            player.getWorld().spawnParticle(Particle.CRIMSON_SPORE, player.getLocation().add(0, 1, 0), 100, 2, 3, 2);
        }
        if (purpleParticleToggleMap.getOrDefault(player, false)){
            Particle.DustOptions puprledustOptions = new Particle.DustOptions(Color.PURPLE, 2.0F);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0.5, 1, 0.5), 10, puprledustOptions);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0.5, 2, 0.5), 10, puprledustOptions);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0.5, 0, 0.5), 10, puprledustOptions);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(-0.5, 1, -0.5), 10, puprledustOptions);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(-0.5, 2, -0.5), 10, puprledustOptions);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(-0.5, 0, -0.5), 10, puprledustOptions);

        }
        if (greenParticleToggleMap.getOrDefault(player, false)) {
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.GREEN, 2.0F);
            player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 1, dustOptions);
        }
    }

    private void toggleParticle(Player player, Particle particle, Map<Player, Boolean> toggleMap) {
        toggleMap.put(player, !toggleMap.getOrDefault(player, false));
    }
}
