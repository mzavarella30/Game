/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Level.Tile;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Graphics.Sprite;

public class Tile {
    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile brick = new BrickFloorTile(Sprite.brick);
    public static Tile mud = new MudTile(Sprite.mud);
    public static Tile wall_ex = new MudTile(Sprite.wall_ex);
    public static Tile wall_in = new MudTile(Sprite.wall_in);
    public static Tile wood = new MudTile(Sprite.wood);




    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public Tile() {

    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }
}
