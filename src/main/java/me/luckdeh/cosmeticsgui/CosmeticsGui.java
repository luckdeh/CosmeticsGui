package me.luckdeh.cosmeticsgui;

import me.luckdeh.cosmeticsgui.Commands.CosmeticsMenuCommand;
import me.luckdeh.cosmeticsgui.Listeners.ParticleListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CosmeticsGui extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("cosmetics").setExecutor(new CosmeticsMenuCommand());

        getServer().getPluginManager().registerEvents(new ParticleListener(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
