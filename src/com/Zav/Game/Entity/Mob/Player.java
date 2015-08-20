/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Entity.Mob;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Graphics.Sprite;
import com.Zav.Game.Input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_u_0;
    }

    public Player(Keyboard input, int x, int y) {
        this.input = input;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;
        if (anim < 7500) anim++;
        else anim = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    public void render(Screen screen) {
        int flip = 0;
        if (dir == 0) {
            sprite = Sprite.player_u_0;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_u_1;
                } else {
                    sprite = Sprite.player_u_2;
                }
            }
        }

        if (dir == 1) {
            sprite = Sprite.player_s_0;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_s_1;
                } else {
                    sprite = Sprite.player_s_2;
                }
            }
        }

        if (dir == 2) {
            sprite = Sprite.player_d_0;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_d_1;
                } else {
                    sprite = Sprite.player_d_2;
                }
            }
        }

        if (dir == 3) {
            flip = 1;
            sprite = Sprite.player_s_0;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_s_1;
                } else {
                    sprite = Sprite.player_s_2;
                }
            }
        }

        screen.renderPlayer(x - 16, y - 16, sprite, flip);
    }
}
