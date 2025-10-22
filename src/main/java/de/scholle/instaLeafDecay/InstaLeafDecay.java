package de.scholle.instaLeafDecay;

import org.bukkit.plugin.java.JavaPlugin;

public class InstaLeafDecay extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getLogger().info("InstaLeafDecay has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("InstaLeafDecay has been disabled!");
    }
}
