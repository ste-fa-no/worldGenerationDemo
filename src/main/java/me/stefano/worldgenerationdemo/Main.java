package me.stefano.worldgenerationdemo;

import me.stefano.worldgenerationdemo.world.biome.Biome;
import me.stefano.worldgenerationdemo.world.World;
import me.stefano.worldgenerationdemo.world.generation.WorldGenerator;
import me.stefano.worldgenerationdemo.world.position.TilePosition;
import me.stefano.worldgenerationdemo.world.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static me.stefano.worldgenerationdemo.ImageGenerator.*;

public class Main {


    static void main() {
        System.out.println("Creating world...");

        WorldGenerator generator = new WorldGenerator(new Random().nextInt());
        World world = new World("World", generator);

        System.out.println("Rendering image from tile map...");

        String outputFileName = "demo_generation.png";
        BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < IMAGE_WIDTH; x++) {
            for (int y = 0; y < IMAGE_HEIGHT; y++) {
                Tile currentTile = world.getTileAt(new TilePosition(world, x - IMAGE_WIDTH / 2, y - IMAGE_HEIGHT / 2));

                if (currentTile == null) {
                    image.setRGB(x, y, Color.MAGENTA.getRGB());
                    continue;
                }

                Biome biome = currentTile.getBiome();
                Color pixelColor = biomeColors.getOrDefault(biome, Color.BLACK);
                image.setRGB(x, y, pixelColor.getRGB());
            }
        }

        try {
            File outputFile = new File(outputFileName);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Image saved as: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
