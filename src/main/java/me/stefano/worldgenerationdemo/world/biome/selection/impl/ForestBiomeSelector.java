package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class ForestBiomeSelector extends AbstractBiomeSelector {

    public ForestBiomeSelector() {
        super(Biome.FOREST);
    }

    public ForestBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.FOREST, next);
    }

}
