package me.stefano.worldgenerationdemo.world.biome.selection.impl;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.biome.selection.AbstractBiomeSelector;

public class VoidBiomeSelector extends AbstractBiomeSelector {

    public VoidBiomeSelector() {
        super(Biome.VOID);
    }

    public VoidBiomeSelector(AbstractBiomeSelector next) {
        super(Biome.VOID, next);
    }

    @Override
    public boolean canHandle(float continentalness, float elevation, float temperature, float humidity) {
        return true;
    }

}
