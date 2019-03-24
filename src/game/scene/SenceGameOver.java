package game.scene;

import game.GameObject;

public class SenceGameOver extends Scene {
    @Override
    public void init(){
        GameObject.recycle(BackgroundGameOver.class);
    }
    @Override
    public void clear(){
        GameObject.clearAll();
    }
}
