package me.stefano.worldgenerationdemo;

import me.stefano.worldgenerationdemo.world.biome.Biome;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageGenerator {


    public static final int IMAGE_WIDTH = 1024;
    public static final int IMAGE_HEIGHT = 1024;

    public static final Map<Biome, Color> biomeColors = new HashMap<>();

    static {
        biomeColors.put(Biome.OCEAN, new Color(0, 0, 128));
        biomeColors.put(Biome.BEACH, new Color(238, 214, 175));
        biomeColors.put(Biome.SNOWY_PEAKS, Color.WHITE);
        biomeColors.put(Biome.MOUNTAINS, new Color(139, 137, 137));
        biomeColors.put(Biome.HILLS, new Color(66, 44, 11));
        biomeColors.put(Biome.TAIGA, new Color(0, 100, 0));
        biomeColors.put(Biome.TUNDRA, new Color(176, 224, 230));
        biomeColors.put(Biome.FOREST, new Color(34, 139, 34));
        biomeColors.put(Biome.PLAINS, new Color(152, 251, 152));
        biomeColors.put(Biome.DESERT, new Color(244, 164, 96));
    }


}
