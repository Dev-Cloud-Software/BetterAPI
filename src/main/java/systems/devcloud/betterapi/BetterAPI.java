/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi;

import lombok.extern.java.Log;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import systems.devcloud.betterapi.utils.Localizer;

/**
 * Main Class of the BetterAPI Plugin.
 */
@Log(topic = "BetterAPI")
public final class BetterAPI extends JavaPlugin {

    public static Localizer localizer;
    private int apiPort;

    @Override
    public void onLoad() {
        Configuration pluginConfig = getConfig();
        localizer = new Localizer(pluginConfig.getString("general.locale"));
        this.apiPort = pluginConfig.getInt("api.port");
        log.info(String.format(localizer.get("plugin.loaded"), localizer.get("prefix")));
    }

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        saveDefaultConfig();
        log.info(String.format(localizer.get("plugin.enabled"), localizer.get("prefix")));
    }

    @Override
    public void onDisable() {
        log.info(String.format(localizer.get("plugin.disabled"), localizer.get("prefix")));
    }
}
