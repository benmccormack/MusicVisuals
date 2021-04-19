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
        mv.hint(PConstants.DISABLE_OPTIMIZED_STROKE);
    }

    public void render(){
        mv.colorMode(PApplet.HSB);
        mv.background(0);
        mv.translate(width/2, height/2);
        mv.noStroke();
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.ellipse(0, 0, 250 + mv.getSmoothedAmplitude() * 50, 250 + mv.getSmoothedAmplitude() * 50);
        mv.fill(0);
        mv.ellipse(0, 0, 200, 200);
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.strokeWeight(3);
        for (int i = 0; i < mv.getAudioBuffer().size(); i++) {
            mv.rotate(PApplet.degrees(angle)); 
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], mv.getAudioBuffer().get(i), 0.1f);
            mv.line(0, 200 + (mv.getSmoothedAmplitude() * 50), 0, (200 + mv.getSmoothedAmplitude() * 50) + (PApplet.abs(lerpedBuffer[i])* 100));
            angle += mv.getAudioBuffer().size() / 360.0f;
        }
    }
}
