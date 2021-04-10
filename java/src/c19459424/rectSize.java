package c19459424;

import processing.core.*;

public class rectSize {
    MyVisual mv;
    float width;
    float height;
    float angle = 0;

    public rectSize(MyVisual mv)
    {
        this.mv = mv;
        width = (float)this.mv.width;
        height = (float)this.mv.height;
        mv.rectMode(PConstants.CENTER);
        mv.getSurface().setLocation(957,0);
    }


    public void render(){
        mv.strokeWeight(15);
        mv.colorMode(PApplet.HSB);
        mv.fill(255);
        mv.background(0,15,30);
        mv.translate(width/2, height/2);
        for(int i = 0; i < 100; i++)
        {
            mv.stroke(0,15,30);
            mv.fill(255);
            mv.scale((float)0.95);
            mv.rotate(PApplet.radians(angle));
            mv.rect(0,0,600,600);
        }
        angle += 0.1;
    }


}
