package me.stefano.worldgenerationdemo.world.generation;

import lombok.Getter;
import lombok.NonNull;
import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.World;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;
import me.stefano.worldgenerationdemo.world.biome.selection.impl.*;
import me.stefano.worldgenerationdemo.world.chunk.Chunk;
import me.stefano.worldgenerationdemo.world.position.ChunkPosition;
import me.stefano.worldgenerationdemo.world.position.TilePosition;
import me.stefano.worldgenerationdemo.world.tile.Tile;
import me.stefano.worldgenerationdemo.world.tile.TileMaterial;

public class WorldGenerator {

    @Getter private final int seed;

    private final NoiseMapGenerator continentalMap;
    private final NoiseMapGenerator elevationMap;
    private final NoiseMapGenerator temperatureMap;
    private final NoiseMapGenerator moistureMap;

    private final AbstractBiomeSelector biomeSelector;

    public WorldGenerator(int seed) {
        this.seed = seed;

        this.continentalMap = new NoiseMapGenerator(seed, 3, 0.004f, 0.5f);
        this.elevationMap = new NoiseMapGenerator((seed + 1), 3, 0.004f, 0.5f);
        this.temperatureMap = new NoiseMapGenerator((seed + 2), 3, 0.004f, 0.5f);
        this.moistureMap = new NoiseMapGenerator((seed + 3), 3, 0.004f, 0.5f);

        this.biomeSelector = new OceanBiomeSelector(new BeachBiomeSelector(new SnowyPeaksBiomeSelector(new MountainsBiomeSelector(new HillsBiomeSelector(new DesertBiomeSelector(new TundraBiomeSelector(new TaigaBiomeSelector(new ForestBiomeSelector(new PlainsBiomeSelector(new VoidBiomeSelector()))))))))));
    }

    public @NonNull Chunk generateChunk(@NonNull ChunkPosition position) {
        World world = position.world();
        Chunk chunk = new Chunk(position);

        for (int localX = 0; localX < Chunk.CHUNK_SIZE; localX++) {
            for (int localY = 0; localY < Chunk.CHUNK_SIZE; localY++) {
                int worldX = (position.x() * Chunk.CHUNK_SIZE) + localX;
                int worldY = (position.y() * Chunk.CHUNK_SIZE) + localY;

                float continentalValue = continentalMap.getValue(worldX, worldY);
                float elevationValue = elevationMap.getValue(worldX, worldY);
                float temperatureValue = temperatureMap.getValue(worldX, worldY);
                float moistureValue = moistureMap.getValue(worldX, worldY);

                Biome biome = biomeSelector.handle(continentalValue, elevationValue, temperatureValue, moistureValue);
                chunk.setTile(localX, localY, new Tile(world, biome, TileMaterial.GRASS, new TilePosition(world, worldX, worldY)));
            }
        }
        return chunk;
    }

}
