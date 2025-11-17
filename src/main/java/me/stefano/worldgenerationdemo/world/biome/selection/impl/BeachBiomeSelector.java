package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class BeachBiomeSelector extends AbstractBiomeSelector {

    public BeachBiomeSelector() {
        super(Biome.BEACH);
    }

    public BeachBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.BEACH, next);
    }

}
