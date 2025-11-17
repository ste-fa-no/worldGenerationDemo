package me.stefano.worldgenerationdemo.world;

import lombok.Getter;
import lombok.NonNull;
import me.stefano.worldgenerationdemo.world.chunk.Chunk;
import me.stefano.worldgenerationdemo.world.generation.WorldGenerator;
import me.stefano.worldgenerationdemo.world.position.ChunkPosition;
import me.stefano.worldgenerationdemo.world.position.TilePosition;
import me.stefano.worldgenerationdemo.world.tile.Tile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class World {

    // TODO: implement world saving and loading

    @Getter
    private final String name;
    @Getter
    private final WorldGenerator generator;

    private final Map<ChunkPosition, Chunk> loadedChunks;

    public World(@NonNull String name, @NonNull WorldGenerator generator) {
        this.name = name;
        this.generator = generator;
        this.loadedChunks = new ConcurrentHashMap<>();
    }

    public Tile getTileAt(@NonNull TilePosition position) {
        Chunk chunk = getChunk(position.toChunkPosition());
        int localX = Math.floorMod(position.x(), Chunk.CHUNK_SIZE);
        int localY = Math.floorMod(position.y(), Chunk.CHUNK_SIZE);
        return chunk.getTile(localX, localY);
    }

    public Chunk getChunk(@NonNull ChunkPosition position) {
        return loadedChunks.computeIfAbsent(position, this::loadOrGenerateChunk);
    }

    private Chunk loadOrGenerateChunk(ChunkPosition position) {
        return generateNewChunk(position);
    }

    private Chunk generateNewChunk(ChunkPosition position) {
        return generator.generateChunk(position);
    }

}