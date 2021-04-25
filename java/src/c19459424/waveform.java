package c19459424;

import processing.core.*;

public class waveform
{
    BensVisual bv;
    float cy = 0;
    float[] lerpedBuffer;

   
    public waveform(BensVisual bv)
    {
        this.bv = bv;
        cy = this.bv.height / 2f;
        lerpedBuffer = new float[bv.width];
    }


    public void render()
    {
        bv.colorMode(PApplet.HSB);
        bv.strokeWeight(1);
        bv.stroke(255);

        for(int i = 0 ; i < bv.getAudioBuffer().size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], bv.getAudioBuffer().get(i), 0.1f);
            bv.line(i, cy - lerpedBuffer[i] * cy, i, cy + lerpedBuffer[i] * cy);
        } 
    }
}