/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Level;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Level.Tile.Tile;

public class Level {

    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;
    public static Level spawn = new SpawnLevel("/textures/level.png");

    private static final int GRASS = 0xFF00FF00;
    private static final int FLOWER = 0xFFFFFF00;
    private static final int ROCK = 0xFF7F7F00;
    private static final int BRICK = 0xFF7F0000;
    private static final int MUD = 0xFF7A4D00;
    private static final int WALL_EX = 0;
    private static final int WALL_IN = 0;
    private static final int WOOD = 0;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }


    protected void generateLevel() {}

    protected void loadLevel(String path) {
    }


    public void update() {
    }

    public void time() {
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        // Setting up the corner pins of the screen! This defines the render region of our screen
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
               getTile(x, y).render(x, y, screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tiles[x + y * width] == GRASS) return Tile.grass;
        if (tiles[x + y * width] == FLOWER) return Tile.flower;
        if (tiles[x + y * width] == ROCK) return Tile.rock;
        if (tiles[x + y * width] == BRICK) return Tile.brick;
        if (tiles[x + y * width] == MUD) return Tile.mud;
        if (tiles[x + y * width] == WALL_EX) return Tile.wall_ex;
        if (tiles[x + y * width] == WALL_IN) return Tile.wall_in;
        if (tiles[x + y * width] == WOOD) return Tile.wood;
        return Tile.voidTile;

    }
}