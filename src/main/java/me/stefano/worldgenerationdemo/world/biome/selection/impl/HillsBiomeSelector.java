package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class HillsBiomeSelector extends AbstractBiomeSelector {

    public HillsBiomeSelector() {
        super(Biome.HILLS);
    }

    public HillsBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.HILLS, next);
    }

}
