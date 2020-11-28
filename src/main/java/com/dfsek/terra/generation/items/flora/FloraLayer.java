package com.dfsek.terra.generation.items.flora;

import com.dfsek.terra.procgen.math.Vector2;
import org.bukkit.Chunk;
import org.polydev.gaea.math.FastNoiseLite;
import org.polydev.gaea.math.ProbabilityCollection;
import org.polydev.gaea.math.Range;
import org.polydev.gaea.world.Flora;

import java.util.Random;

public class FloraLayer {
    private final double density;
    private final Range level;
    private final ProbabilityCollection<Flora> layer;
    private final FastNoiseLite noise;

    public FloraLayer(double density, Range level, ProbabilityCollection<Flora> layer, FastNoiseLite noise) {
        this.density = density;
        this.level = level;
        this.layer = layer;
        this.noise = noise;
    }

    public double getDensity() {
        return density;
    }

    public void plant(Chunk chunk, Vector2 coords, Random random) {
        Flora item = noise == null ? layer.get(random) : layer.get(noise, (chunk.getX() << 4) + coords.getX(), (chunk.getZ() << 4) + coords.getZ());
        item.getValidSpawnsAt(chunk, (int) coords.getX(), (int) coords.getZ(), level).forEach(block -> item.plant(block.getLocation()));
    }
}
