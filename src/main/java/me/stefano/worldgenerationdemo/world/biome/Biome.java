package me.stefano.worldgenerationdemo.world.biome;

import lombok.AllArgsConstructor;
import me.stefano.worldgenerationdemo.math.Interval;

/**
 * Biome table to be thrown into the biome selection chain of responsibility.
 * Biomes must be handled in the order of declaration.
 */
@AllArgsConstructor
public enum Biome {

    VOID(Interval.empty(), Interval.empty(), Interval.empty(), Interval.empty()),

    OCEAN(Interval.of(-1f, 1f), Interval.of(-1f, 0.1f),    Interval.of(-1f, 1f),    Interval.of(-1f, 1f)),
    BEACH(Interval.of(-1f, 1f), Interval.of(0.1f, 0.15f), Interval.of(-1f, 1f), Interval.of(-1f, 1f)),

    SNOWY_PEAKS(Interval.of(-1f, 1f), Interval.of(0.8f, 1f),      Interval.of(-1f, -0.5f), Interval.of(-1f, 1f)),
    MOUNTAINS(Interval.of(-1f, 1f), Interval.of(0.65f, 1f),     Interval.of(-1f, 1f),    Interval.of(-1f, 1f)),
    HILLS(Interval.of(-1f, 1f), Interval.of(0.4f, 0.65f),    Interval.of(-1f, 1f),    Interval.of(-1f, 1f)),

    DESERT(Interval.of(0.3f, 1f),    Interval.of(0.15f, 0.4f),  Interval.of(0.7f, 1f),     Interval.of(-1f, -0.4f)),
    TUNDRA(Interval.of(-1f, 1f),    Interval.of(0.15f, 0.4f),  Interval.of(-1f, -0.5f),   Interval.of(-1f, 0.1f)),
    TAIGA(Interval.of(-1f, 1f),     Interval.of(0.15f, 0.4f),  Interval.of(-0.5f, 0.1f),  Interval.of(0.1f, 1f)),

    FOREST(Interval.of(-1f, 1f),    Interval.of(0.15f, 0.4f),  Interval.of(0.1f, 1f),     Interval.of(0.3f, 1f)),
    PLAINS(Interval.of(-1f, 1f),    Interval.of(0.15f, 0.4f),  Interval.of(-1f, 1f),    Interval.of(-1f, 1f));


    private final Interval continentalness;
    private final Interval elevation;
    private final Interval temperature;
    private final Interval humidity;

    public boolean matches(float continentalness, float elevation, float temperature, float humidity) {
        return this.continentalness.contains(continentalness) && this.elevation.contains(elevation) && this.temperature.contains(temperature) && this.humidity.contains(humidity);
    }

}
