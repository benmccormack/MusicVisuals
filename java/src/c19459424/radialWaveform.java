package c19459424;

import processing.core.*;

public class radialWaveform{
    BensVisual bv;
    float width;
    float height;
    float angle = 0;
    float boxAngle = 0;
    float[] lerpedBuffer;

    public radialWaveform(BensVisual bv)
    {
        this.bv = bv; 
        width = this.bv.width;
        height = this.bv.height;
        lerpedBuffer = new float[bv.width];
        bv.hint(PConstants.DISABLE_OPTIMIZED_STROKE);
    }

    public void render(){
        bv.colorMode(PApplet.HSB);
        bv.ellipse(width/6, height/5, 100 + bv.getSmoothedAmplitude() * 100, 100 + bv.getSmoothedAmplitude() * 100);
        bv.ellipse(width/6, height - (height/5), 100 + bv.getSmoothedAmplitude() * 100, 100 + bv.getSmoothedAmplitude() * 100);
        bv.ellipse(width - (width/6), height - (height/5), 100 + bv.getSmoothedAmplitude() * 100, 100 + bv.getSmoothedAmplitude() * 100);
        bv.ellipse(width - (width/6), height/5, 100 + bv.getSmoothedAmplitude() * 100, 100 + bv.getSmoothedAmplitude() * 100);
        bv.translate(width/2, height/2); //drawing from center of the screen
        bv.fill(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        bv.stroke(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        bv.strokeWeight(3);

        bv.pushMatrix();
        //plotting one line on each degree of the circle
        for (int i = 0; i < bv.getAudioBuffer().size(); i++) {
            bv.rotate(PApplet.degrees(angle)); 
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], bv.getAudioBuffer().get(i), 0.1f);
            bv.line(0, 200 + (bv.getSmoothedAmplitude() * 50), 0, (200 + bv.getSmoothedAmplitude() * 50) + (PApplet.abs(lerpedBuffer[i])* 100));
            angle += bv.getAudioBuffer().size() / 360.0f;
        }
        bv.popMatrix();

        //drawing rotating cube that pulses to music inside the radial waveform
        bv.pushMatrix();
        bv.rotateY(boxAngle); 
        bv.rotateX(boxAngle);
        bv.lights(); //adding lights
        boxAngle += 0.01f; //increasing angle value, increases rotation
        float s = 100 * bv.getSmoothedAmplitude() * 5;
        bv.box(s);
        bv.fill(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255); //fill colour change using amplitude
        bv.popMatrix();

    }
}
