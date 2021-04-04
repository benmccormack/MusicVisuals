package c19459424;

import processing.core.*;

public class waveform
{
    MyVisual mv;
    float cy = 0;
    float[] lerpedBuffer;

    public waveform(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
    }


    public void render()
    {
        mv.colorMode(PApplet.HSB);
        mv.strokeWeight(1);

        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(255);
            mv.line(i, cy - mv.getAudioBuffer().get(i) * cy, i, cy + mv.getAudioBuffer().get(i) * cy );
        } 
    }
}