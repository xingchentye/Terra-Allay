package com.dfsek.terra.api.core;

import com.dfsek.terra.addons.addon.TerraAddon;
import com.dfsek.terra.api.LoaderRegistrar;
import com.dfsek.terra.api.core.event.EventManager;
import com.dfsek.terra.api.platform.handle.ItemHandle;
import com.dfsek.terra.api.platform.handle.WorldHandle;
import com.dfsek.terra.api.platform.world.World;
import com.dfsek.terra.config.PluginConfig;
import com.dfsek.terra.config.lang.Language;
import com.dfsek.terra.config.pack.ConfigPack;
import com.dfsek.terra.debug.DebugLogger;
import com.dfsek.terra.registry.CheckedRegistry;
import com.dfsek.terra.registry.LockedRegistry;
import com.dfsek.terra.world.TerraWorld;

import java.io.File;
import java.util.logging.Logger;

public interface TerraPlugin extends LoaderRegistrar {
    WorldHandle getWorldHandle();

    boolean isEnabled();

    TerraWorld getWorld(World world);

    Logger getLogger();

    PluginConfig getTerraConfig();

    File getDataFolder();

    boolean isDebug();

    Language getLanguage();

    CheckedRegistry<ConfigPack> getConfigRegistry();

    LockedRegistry<TerraAddon> getAddons();

    boolean reload();

    ItemHandle getItemHandle();

    void saveDefaultConfig();

    String platformName();

    DebugLogger getDebugLogger();

    EventManager getEventManager();
}
