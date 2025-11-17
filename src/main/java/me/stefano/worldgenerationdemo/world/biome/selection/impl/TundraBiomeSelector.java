package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class TundraBiomeSelector extends AbstractBiomeSelector {

    public TundraBiomeSelector() {
        super(Biome.TUNDRA);
    }

    public TundraBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.TUNDRA, next);
    }

}
