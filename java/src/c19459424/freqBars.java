package c19459424;

import processing.core.*;

public class freqBars {
    MyVisual mv;

    public freqBars(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        mv.colorMode(PApplet.HSB);
        float gap = mv.height / (float) mv.getBands().length;
        mv.noStroke();
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            //mv.fill(mv.getSmoothedAmplitude()*10,20,20);
            mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //fill colour change using amplitude
            mv.rect(0, i * gap ,-mv.getSmoothedBands()[i] * 0.2f, gap - (float)mv.width/8); 
            mv.rect(mv.width, i * gap,-mv.getSmoothedBands()[i] * 0.2f, gap - (float)mv.width/8); 
            mv.ellipse(mv.width/2, mv.height/2, mv.getSmoothedAmplitude() * mv.width, mv.getSmoothedAmplitude() * mv.width);
            //mv.ellipse(mv.width/2, mv.height/2, mv.width/4, mv.width/4);
        }
    }
}
