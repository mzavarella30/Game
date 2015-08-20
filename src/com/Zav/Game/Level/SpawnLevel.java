package com.Zav.Game.Level;

import com.Zav.Game.Level.Tile.GrassTile;
import com.Zav.Game.Level.Tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level{

    private Tile[] tiles;
    private int[] levelPixels;

    private static final int GRASS = 0xff00;
    private static final int FLOWER = 0xFFFF00;
    private static final int ROCK = 0x7F7F00;

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles = new Tile[w * h];
            image.getRGB(0, 0, w, h, levelPixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load level, my bad!");
        }
    }

    @Override
    protected void generateLevel() {
        for (int i = 0; i < levelPixels.length; i++) {
            if (levelPixels[i] == GRASS) tiles[i] = Tile.grass;
            if (levelPixels[i] == FLOWER) tiles[i] = Tile.flower;
            if (levelPixels[i] == ROCK) tiles[i] = Tile.rock;
        }
    }
}
