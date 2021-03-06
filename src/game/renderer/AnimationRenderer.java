package game.renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import javax.lang.model.element.AnnotationMirror;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AnimationRenderer extends Renderer
{
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int changeImageCount;
    public int frameChange;
    public boolean isOnce;

    public AnimationRenderer (ArrayList<BufferedImage> images,int frameChange)
    {
        this.images = images;
        this.currentImageIndex = 0;
        this.changeImageCount = 0;
        this.frameChange = frameChange;
        this.isOnce = false;
    }

//
//    public Animation(ArrayList<BufferedImage> images,int nextImageCout , boolean isOnce){
//        this.images = images;
//        this.currentImageIndex = 0;
//        this.renderCouter = new FrameCounter();
//    }


    public AnimationRenderer(String directoryPath, int frameChange)
    {
        this(directoryPath,frameChange,false);//goi lai ham tao
    }
    public AnimationRenderer(String directoryPath,int frameChange , boolean isOnce)
    {
        File folder = new File(directoryPath);
        java.util.List<String> fileNames = Arrays.asList(folder.list());
        fileNames.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(fileNames);
        ArrayList<BufferedImage> images = new ArrayList<>();

        for(String filename : fileNames)
        {
            if(filename.endsWith(".png")) {
                images.add(SpriteUtils.loadImage(directoryPath + "/" + filename));
            }
        }
        this.images = images;
        this.currentImageIndex = 0;
        this.changeImageCount = 0;
        this.frameChange = frameChange;
        this.isOnce = isOnce;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage currentImage = images.get(currentImageIndex);
        g.drawImage(
                currentImage,
                (int) (master.position.x - (master.anchor.x * currentImage.getWidth())),
                (int) (master.position.y - (master.anchor.y * currentImage.getHeight())),
                null
        );

        changeImageCount++;
        if(changeImageCount > frameChange) {
            currentImageIndex++;
            if(currentImageIndex >= images.size()) {
                if(isOnce)
                {
                    master.deactive();
                } else
                {
                    currentImageIndex = 0;
                }
                currentImageIndex = 0;
            }
            changeImageCount = 0;
        }
    }
}
