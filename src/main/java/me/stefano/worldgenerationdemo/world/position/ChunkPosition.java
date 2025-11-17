package me.stefano.worldgenerationdemo.world.position;

import lombok.NonNull;
import me.stefano.worldgenerationdemo.math.Point;
import me.stefano.worldgenerationdemo.world.World;
import me.stefano.worldgenerationdemo.world.chunk.Chunk;

/**
 * Represents a Chunk's position in the game world.
 * @param world
 * @param x
 * @param y
 */
public record ChunkPosition(World world, int x, int y) implements Point<ChunkPosition> {

    @Override
    public double distance(ChunkPosition other) {
        return Math.sqrt(x * x + y * y);
    }

    public @NonNull Chunk getChunk() {
        if (NULL.equals(this)) return Chunk.NULL;
        return world.getChunk(this);
    }

    public static final ChunkPosition NULL = new ChunkPosition(null, 0, 0);

}
