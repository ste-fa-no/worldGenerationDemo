package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class TaigaBiomeSelector extends AbstractBiomeSelector {

    public TaigaBiomeSelector() {
        super(Biome.TAIGA);
    }

    public TaigaBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.TAIGA, next);
    }

}
