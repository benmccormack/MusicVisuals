package c19459424;

import ie.tudublin.MyVisual;
import processing.core.*;

public class cubeVisual{
    MyVisual mv;
    float width;
    float height;
    float angle = 0;

    public cubeVisual(MyVisual mv)
    {
        this.mv = mv; 
        width = this.mv.width;
        height = this.mv.height;
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);
        //frequency bars
        float gap = mv.width / (float) mv.getBands().length;
        mv.noStroke();
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //fill colour change using amplitude
            mv.rect(mv.width, i * gap,-mv.getSmoothedBands()[i] * 0.2f, gap - (float)mv.width/8); 
            mv.rect(0, i * gap ,-mv.getSmoothedBands()[i] * 0.2f, gap - (float)mv.width/8); 
        }

        mv.pushMatrix();
        mv.translate(width/2, height/2, 0); //translating whatever is drawn to center of screen
        mv.rotateY(angle); 
        mv.rotateX(angle);
        mv.lights(); //adding lights
        mv.strokeWeight(2);
        mv.noFill();
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //stroke color change using amplitude
        angle += 0.01f; //increasing angle value, increases rotation
        float s = 100 * mv.getSmoothedAmplitude() * 10;
        mv.box(s);
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //fill colour change using amplitude
        mv.sphere(s / 2); //radius of sphere smaller than box so it can fit inside
        mv.popMatrix();
    }
} 