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
        if (input.up) y--;
        if (input.down) y++;
        if (input.left) x--;
        if (input.right) x++;
    }

    @Override
    public void render() {
    }
}
