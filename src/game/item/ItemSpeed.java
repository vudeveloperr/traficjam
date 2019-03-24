package game.item;

import game.Settings;
import game.player.Player;

import game.renderer.AnimationRenderer;

public class ItemSpeed extends Item {
    public ItemSpeed(){

        this.renderer = new AnimationRenderer("/Users/nguyenvanvu/Documents/CI15/Game_Traffic_Jam/ci-begin-master copy/assets/images/items/speedUp",10);
        this.velocity.set(0,3);

    }

    @Override
    public void powerUp(){
        Settings.ENEMY_SPEED = 3;
        Settings.BACKGROUND_SPEED = 1;
        Settings.ITEM_SPEED_FRAME_LEFT = 120;
    }
}

