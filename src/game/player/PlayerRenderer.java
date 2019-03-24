package game.player;

import game.GameObject;
import game.renderer.AnimationRenderer;
import game.renderer.Renderer;

import java.awt.*;

public class PlayerRenderer extends Renderer {
    AnimationRenderer leftAnimation;
    AnimationRenderer rightAnimation;
    AnimationRenderer straightAnimation;
    int renderCount1;
    public PlayerRenderer()
    {
        leftAnimation = new AnimationRenderer("/Users/nguyenvanvu/Documents/CI15/Game_Traffic_Jam/ci-begin-master copy/assets/images/players/left",10);
        rightAnimation = new AnimationRenderer("/Users/nguyenvanvu/Documents/CI15/Game_Traffic_Jam/ci-begin-master copy/assets/images/players/right",10);
        straightAnimation = new AnimationRenderer("/Users/nguyenvanvu/Documents/CI15/Game_Traffic_Jam/ci-begin-master copy/assets/images/players/straight",10);
    }

    @Override
    public void render(Graphics g, GameObject master)
    {
//        renderCount1++;
//        if(player.immune && renderCount1 % 2 ==0)
//        {
//            return;
//        }
        if(master.velocity.x < 0)
        {
            leftAnimation.render(g,master);
        }else if(master.velocity.x > 0)
        {
            rightAnimation.render(g,master);
        }else
        {
            straightAnimation.render(g,master);
        }
    }
}
