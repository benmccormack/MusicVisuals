package c19459424;

import processing.core.*;

public class cubeVisual{
    BensVisual bv;
    float width;
    float height;
    float angle = 0;

    public cubeVisual(BensVisual bv)
    {
        this.bv = bv; 
        width = this.bv.width;
        height = this.bv.height;
    }

    public void render()
    {
        bv.colorMode(PApplet.HSB);
        //frequency bars
        float gap = bv.width / (float) bv.getBands().length;
        bv.noStroke();
        for(int i = 0 ; i < bv.getBands().length ; i ++)
        {
            bv.fill(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //fill colour change using amplitude
            bv.rect(bv.width, i * gap,-bv.getSmoothedBands()[i] * 0.2f, gap - (float)bv.width/8); 
            bv.rect(0, i * gap ,-bv.getSmoothedBands()[i] * 0.2f, gap - (float)bv.width/8); 
        }

        //drawing cube + sphere inside cube
        bv.pushMatrix();
        bv.translate(width/2, height/2, 0); //translating whatever is drawn to center of screen
        bv.rotateY(angle); 
        bv.rotateX(angle);
        bv.lights(); //adding lights
        bv.strokeWeight(2);
        bv.noFill();
        bv.stroke(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //stroke color change using amplitude
        angle += 0.01f; //increasing angle value, increases rotation
        float s = 100 * bv.getSmoothedAmplitude() * 10;
        bv.box(s);
        bv.fill(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //fill colour change using amplitude
        bv.sphere(s / 2); //radius of sphere smaller than box so it can fit inside
        bv.popMatrix();
    }
} 