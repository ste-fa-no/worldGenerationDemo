package me.stefano.worldgenerationdemo.world.chunk;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.stefano.worldgenerationdemo.world.position.ChunkPosition;
import me.stefano.worldgenerationdemo.world.position.TilePosition;
import me.stefano.worldgenerationdemo.world.tile.Tile;

public class Chunk {

    public static final int CHUNK_SIZE = 16;

    private final ChunkPosition position;
    private final Tile[][] tiles;

    @Setter @Getter private boolean dirty;

    public Chunk(ChunkPosition position) {
        this.position = position;
        this.tiles = new Tile[CHUNK_SIZE][CHUNK_SIZE];
        this.dirty = false;

        // Is this really necessary?
        for (int i = 0; i < CHUNK_SIZE; i++)
            for (int j = 0; j < CHUNK_SIZE; j++)
                tiles[i][j] = Tile.NULL;
    }

    public Tile getTile(int localX, int localY) {
        return tiles[localX][localY];
    }

    public Tile getTile(@NonNull TilePosition position) {
        return tiles[position.x()][position.y()];
    }

    public void setTile(int localX, int localY, Tile tile) {
        tiles[localX][localY] = tile;
        setDirty(true); // Marca il chunk come modificato!
    }

    public static final Chunk NULL = new Chunk(ChunkPosition.NULL);

}