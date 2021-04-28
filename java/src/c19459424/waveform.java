package c19459424;

import processing.core.*;

public class waveform
{
    BensVisual bv;
    float halfWidth;
    float[] lerpedBuffer;

   
    public waveform(BensVisual bv)
    {
        this.bv = bv;
        halfWidth = this.bv.height / 2f;
        lerpedBuffer = new float[bv.width];
    }


    public void render()
    {
        bv.colorMode(PApplet.HSB);
        bv.strokeWeight(1);
        bv.stroke(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);

        for(int i = 0 ; i < bv.getAudioBuffer().size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], bv.getAudioBuffer().get(i), 0.1f);
            bv.line(i, halfWidth - lerpedBuffer[i] * halfWidth, i, halfWidth + lerpedBuffer[i] * halfWidth);
        } 
    }
}