package c19459424;

import processing.core.*;

public class freqBars {
    BensVisual bv;

    public freqBars(BensVisual bv)
    {
        this.bv = bv; 
    }

    public void render()
    {
        bv.colorMode(PApplet.HSB);
        float gap = bv.height / (float) bv.getBands().length;
        bv.noStroke();
        for(int i = 0 ; i < bv.getBands().length ; i ++)
        {
            bv.fill(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //fill colour change using amplitude
            bv.rect(0, i * gap ,-bv.getSmoothedBands()[i] * 0.2f, gap - (float)bv.width/8); 
            bv.rect(bv.width, i * gap,-bv.getSmoothedBands()[i] * 0.2f, gap - (float)bv.width/8); 
            bv.ellipse(bv.width/2, bv.height/2, bv.getSmoothedAmplitude() * bv.width, bv.getSmoothedAmplitude() * bv.width);
        }
    }
}
