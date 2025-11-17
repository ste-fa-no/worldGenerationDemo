package me.stefano.worldgenerationdemo.world.position;

import me.stefano.worldgenerationdemo.math.Point;
import me.stefano.worldgenerationdemo.world.World;

public record Location(World world, double x, double y) implements Point<Location> {

    @Override
    public double distance(Location other) {
        if (this.world != other.world) throw new IllegalArgumentException();
        return Math.sqrt(x * x + y * y);
    }

    public static final Location NULL = new Location(null, 0, 0);

}
