package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class DesertBiomeSelector extends AbstractBiomeSelector {

    public DesertBiomeSelector() {
        super(Biome.DESERT);
    }

    public DesertBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.DESERT, next);
    }

}
