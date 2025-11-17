package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class PlainsBiomeSelector extends AbstractBiomeSelector {

    public PlainsBiomeSelector() {
        super(Biome.PLAINS);
    }

    public PlainsBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.PLAINS, next);
    }

}
