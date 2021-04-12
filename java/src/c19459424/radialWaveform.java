package c19459424;

import processing.core.*;

public class radialWaveform {
    MyVisual mv;
    float width;
    float height;
    float angle = 0;
    float[] lerpedBuffer;

    public radialWaveform(MyVisual mv)
    {
        this.mv = mv; 
        width = this.mv.width;
        height = this.mv.height;
        lerpedBuffer = new float[mv.width];
    }

    public void render(){
        mv.colorMode(PApplet.HSB);

        mv.translate(width/2, height/2);
        mv.fill(255);
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.ellipse(0,0,height/ 3 + mv.getSmoothedAmplitude() * 100,height/ 3 + mv.getSmoothedAmplitude() * 100);
        mv.strokeWeight(3);
        for (int i = 0; i < mv.getAudioBuffer().size(); i++) {
            mv.rotate(PApplet.radians(angle)); 
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], mv.getAudioBuffer().get(i), 0.1f);
            mv.line(height/6, 0,mv.getAudioBuffer().get(i)* 200, 0);
        }
        angle += 0.001f;

    }
}
