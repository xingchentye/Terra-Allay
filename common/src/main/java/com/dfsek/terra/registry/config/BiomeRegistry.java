package com.dfsek.terra.registry.config;

import com.dfsek.tectonic.exception.LoadException;
import com.dfsek.tectonic.loading.ConfigLoader;
import com.dfsek.terra.api.world.biome.TerraBiome;
import com.dfsek.terra.registry.OpenRegistry;

import java.lang.reflect.Type;

public class BiomeRegistry extends OpenRegistry<TerraBiome> {
    @Override
    public TerraBiome load(Type type, Object o, ConfigLoader configLoader) throws LoadException {
        if(o.equals("SELF")) return null;
        TerraBiome biome = get((String) o);
        if(biome == null)
            throw new LoadException("No such " + type.getTypeName() + " matching \"" + o + "\" was found in this registry.");
        return biome;
    }
}
