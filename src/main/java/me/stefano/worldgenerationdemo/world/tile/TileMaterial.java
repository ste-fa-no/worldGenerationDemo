package me.stefano.worldgenerationdemo.world.tile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TileMaterial {

    AIR(false, false, true),
    GRASS(true, false, true),
    WATER(false, true, false),
    ;

    @Getter private final boolean solid;
    @Getter private final boolean liquid;
    @Getter private final boolean transparent;

}
