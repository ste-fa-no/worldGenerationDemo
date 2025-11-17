package me.stefano.worldgenerationdemo.world.tile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.World;
import me.stefano.worldgenerationdemo.world.chunk.Chunk;
import me.stefano.worldgenerationdemo.world.position.TilePosition;

@AllArgsConstructor
@Getter
public class Tile {

    private final World world;
    private final Biome biome;
    private final TileMaterial material;
    private final TilePosition location;

    public @NonNull Chunk getChunk() {
        return location.toChunkPosition().getChunk();
    }

    @Override
    public String toString() {
        return "Biome: " + biome.name() + " Material: " + material.name() + " Position: " + location.world().getName() + "@(" + location.x() + ", " + location.y() + ")";
    }

    public static final Tile NULL = new Tile(null, Biome.VOID, TileMaterial.AIR, TilePosition.NULL);

}
