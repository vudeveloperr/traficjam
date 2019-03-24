package game.scene;

import game.GameObject;
import game.Settings;
import game.renderer.AnimationRenderer;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver(){
        renderer = new AnimationRenderer("/Users/nguyenvanvu/Documents/CI15/Game_Traffic_Jam/ci-begin-master copy/assets/images/background/GOver",10);
        this.position.set(Settings.GAME_WIDTH /2 , Settings.GAME_HEIGHT/2);
    }


}
