package c19459424;

import ie.tudublin.MyVisual;
import processing.core.*;

public class cubeVisual{
    MyVisual mv;

    public cubeVisual(MyVisual mv)
    {
        this.mv = mv; 
    }
    float angle = 0;
    float angle2 = 0;

    public void render()
    {
        mv.colorMode(PApplet.HSB);

        for(int i = 0; i<mv.getAudioBuffer().size(); i++)
        {
            mv.translate(0, 0);
            mv.line(i, mv.width, i, mv.width + mv.width / 2 * mv.getAudioBuffer().get(i));
        }
        
        mv.pushMatrix();
        mv.translate(mv.width/2, mv.height/2, 0);
        mv.rotateY(angle);
        mv.rotateX(angle);
        mv.lights();
        mv.strokeWeight(2);
        mv.noFill();
        mv.stroke(
            PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255)
            , 255
            , 255
        );
        angle += 0.01f;
        float bigS = 100 * mv.getSmoothedAmplitude() * 10;
        mv.box(bigS);
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255)
        , 255
        , 255);
        mv.sphere(bigS / 2);
        mv.popMatrix();
      
    }
} 