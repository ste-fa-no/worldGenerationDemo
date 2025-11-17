package me.stefano.worldgenerationdemo.world.generation;

import lombok.NonNull;
import me.stefano.worldgenerationdemo.math.FastNoiseLite;

public class NoiseMapGenerator {

    @NonNull private final FastNoiseLite noise;

    public NoiseMapGenerator(int seed, int octaves, float frequency, float gain) {
        this.noise = new FastNoiseLite(seed);
        this.noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        this.noise.SetFrequency(frequency);
        this.noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        this.noise.SetFractalOctaves(octaves);
        this.noise.SetFractalGain(gain);
    }

    public float getValue(float x, float y) {
        return this.noise.GetNoise(x, y);
    }

}
