package me.stefano.worldgenerationdemo.world.biome.selection;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.stefano.worldgenerationdemo.world.biome.Biome;

@AllArgsConstructor
public abstract class AbstractBiomeSelector {

    @NonNull private final Biome biome;
    private final AbstractBiomeSelector next;

    public AbstractBiomeSelector(@NonNull Biome biome) {
        this.biome = biome;
        this.next = null;
    }

    public boolean canHandle(float continentalness, float elevation, float temperature, float humidity) {
        return biome.matches(continentalness, elevation, temperature, humidity);
    }

    public @NonNull Biome handle(float continentalness, float elevation, float temperature, float humidity) {
        if (this.canHandle(continentalness, elevation, temperature, humidity)) return biome;
        if (this.next == null) return biome;
        return this.next.handle(continentalness, elevation, temperature, humidity);
    }

}
