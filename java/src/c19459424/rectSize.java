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
        mv.hint(PConstants.DISABLE_OPTIMIZED_STROKE);
    }


    public void render(){
        mv.strokeWeight(20);
        mv.colorMode(PApplet.HSB);
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.stroke(0,15,30);
        mv.background(0,15,30);
        mv.translate(width/2, height/2);
        float scaleVar = PApplet.map(mv.mouseX, 0 ,width, (float)0.5,10);
        mv.scale(scaleVar);
        for(int i = 0; i < 100; i++)
        {
            mv.scale((float)0.95);
            mv.rotate(PApplet.radians(angle));
            mv.rect(0,0,500 + mv.getSmoothedAmplitude() * 200 ,500 + mv.getSmoothedAmplitude() * 200);
        }
        angle += 0.05;
    }


}
