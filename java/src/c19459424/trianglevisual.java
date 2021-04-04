package c19459424;

import processing.core.*;

public class trianglevisual {
    MyVisual mv;
    float width;
    float height;
    float angle = 0;

    public trianglevisual(MyVisual mv)
    {
        this.mv = mv;
        width = (float)this.mv.width;
        height = (float)this.mv.height;
        mv.rectMode(PConstants.CENTER);
        mv.strokeWeight(15);
        mv.getSurface().setLocation(957,0);
    }


    public void render(){
        mv.fill(255);
        //mv.rectMode(PConstants.CENTER);
        mv.background(0,15,30);
        mv.translate(width/2, height/2);

        for(int i = 0; i < 100; i++)
        {
            mv.stroke(0,15,30);
            mv.fill((float)i*10, 15, 30);
            mv.scale((float)0.95);
            mv.rotate(PApplet.radians(angle));
            line(height,width)
        }
        angle += 0.1;
    }
}
