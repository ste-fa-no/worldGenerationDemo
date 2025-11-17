package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class SnowyPeaksBiomeSelector extends AbstractBiomeSelector {

    public SnowyPeaksBiomeSelector() {
        super(Biome.SNOWY_PEAKS);
    }

    public SnowyPeaksBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.SNOWY_PEAKS, next);
    }

}
