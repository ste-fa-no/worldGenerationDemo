package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class OceanBiomeSelector extends AbstractBiomeSelector {

    public OceanBiomeSelector() {
        super(Biome.OCEAN);
    }

    public OceanBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.OCEAN, next);
    }

}
