package me.stefano.worldgenerationdemo.world.position;

import me.stefano.worldgenerationdemo.math.Point;
import me.stefano.worldgenerationdemo.world.World;
import me.stefano.worldgenerationdemo.world.chunk.Chunk;
import me.stefano.worldgenerationdemo.world.tile.Tile;

/**
 * Represents a Tile's position in the game world.
 * @param world
 * @param x
 * @param y
 */
public record TilePosition(World world, int x, int y) implements Point<TilePosition> {

    @Override
    public double distance(TilePosition other) {
        return Math.sqrt(x * x + y * y);
    }

    public Tile getTile() {
        if (NULL.equals(this)) return Tile.NULL;
        return world.getTileAt(this);
    }

    public ChunkPosition toChunkPosition() {
        int chunkX = Math.floorDiv(this.x, Chunk.CHUNK_SIZE);
        int chunkY = Math.floorDiv(this.y, Chunk.CHUNK_SIZE);
        return new ChunkPosition(this.world, chunkX, chunkY);
    }

    public static final TilePosition NULL = new TilePosition(null, 0, 0);

}
