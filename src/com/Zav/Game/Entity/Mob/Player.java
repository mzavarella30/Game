/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Entity.Mob;

import com.Zav.Game.Input.Keyboard;

public class Player extends Mob {

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
    }

    public Player(Keyboard input, int x, int y) {
        this.input = input;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;
        if (xa != 0 || ya != 0) move(xa, ya);
    }

    @Override
    public void render() {
    }
}
