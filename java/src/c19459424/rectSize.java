package c19459424;

import processing.core.*;

public class rectSize{
    BensVisual bv;
    float width;
    float height;
    float angle = 0;

    public rectSize(BensVisual bv)
    {
        this.bv = bv;
        width = (float)this.bv.width;
        height = (float)this.bv.height;
        bv.rectMode(PConstants.CENTER); //drawing from center rather than corner
        bv.hint(PConstants.DISABLE_OPTIMIZED_STROKE); //disable stroke from prev shape showing over next
    }


    public void render(){
        bv.strokeWeight(20);
        bv.colorMode(PApplet.HSB);
        bv.fill(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        bv.stroke(0,15,30);
        bv.background(0,15,30);
        bv.translate(width/2, height/2);

        //mouse scaling - draw mouse across x axis of screen to scale visual
        float scaleVar = PApplet.map(bv.mouseX, 0 ,width, (float)0.5,10);
        bv.scale(scaleVar);

        //for loop to draw rectangles
        for(int i = 0; i < 100; i++)
        {
            bv.scale((float)0.95);
            bv.rotate(PApplet.radians(angle));
            bv.rect(0,0,500 + bv.getSmoothedAmplitude() * 200 ,500 + bv.getSmoothedAmplitude() * 200);
        }
        angle += 0.05; //angle is increased
    }


}
