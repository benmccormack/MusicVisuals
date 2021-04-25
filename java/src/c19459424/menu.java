package c19459424;
import processing.core.*;


public class menu {
    BensVisual bv;

    public menu(BensVisual bv)
    {
        this.bv = bv; 
        bv.rectMode(PConstants.CENTER); //drawing from center rather than corner
    }

    public void render()
    {
        bv.textAlign(PConstants.CENTER, PConstants.CENTER);
        bv.translate(bv.width/2f, bv.height/3f);
        bv.textSize(30);
        bv.fill(255);
        bv.stroke(255);
        bv.text("Music Visuals",0,0);
        bv.textSize(16);
        bv.text("By Ben McCormack | C19459424",0,50);
        bv.textSize(20);
        bv.text("Press SPACE to start playing music",0,100);
        bv.text("Control visuals on screen with keys 1-6",0,150);
    }
    
}
