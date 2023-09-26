/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi;

import lombok.extern.java.Log;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import systems.devcloud.betterapi.controller.RestController;
import systems.devcloud.betterapi.utils.Localizer;

/**
 * Main Class of the BetterAPI Plugin.
 */
@Log(topic = "BetterAPI")
public final class BetterAPI extends JavaPlugin {
    private RestController restController;
    public static Localizer localizer;
    private int apiPort;

    @Override
    public void onLoad() {
        saveDefaultConfig();
        Configuration pluginConfig = getConfig();
        localizer = new Localizer(pluginConfig.getString("general.language"));
        this.apiPort = pluginConfig.getInt("general.api.port");
        this.restController = new RestController();
        log.info(String.format(localizer.get("plugin.loaded"), localizer.get("prefix")));
    }

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        restController.startServer(apiPort);
        log.info(String.format(localizer.get("plugin.enabled"), localizer.get("prefix")));
    }

    @Override
    public void onDisable() {
        log.info(String.format(localizer.get("plugin.disabled"), localizer.get("prefix")));
    }
}
