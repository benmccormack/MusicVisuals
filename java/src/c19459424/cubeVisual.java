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

        // for loop for waveform
        for(int i = 0; i<mv.getAudioBuffer().size(); i++)
        {
            mv.translate(0, 0);
            mv.line(i, width, i, width + width / 2 * mv.getAudioBuffer().get(i));
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