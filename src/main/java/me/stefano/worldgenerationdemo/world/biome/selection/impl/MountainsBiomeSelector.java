package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class MountainsBiomeSelector extends AbstractBiomeSelector {

    public MountainsBiomeSelector() {
        super(Biome.MOUNTAINS);
    }

    public MountainsBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.MOUNTAINS, next);
    }

}
