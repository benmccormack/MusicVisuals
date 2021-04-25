package c19459424;

import processing.core.*;

public class pyramidVisual {
    BensVisual bv;
    float width;
    float height;
    float[] lerpedBuffer;

    public pyramidVisual(BensVisual bv)
    {
        this.bv = bv; 
        width = this.bv.width;
        height = this.bv.height;
        lerpedBuffer = new float[bv.width];
    }

    float angle = 0;
  
    float size = 100; //size variable for vertices and box

    public void render()
    {
        bv.colorMode(PApplet.HSB);
        bv.lights();
        bv.noFill();
        bv.strokeWeight(4);
        bv.stroke(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);

        //generating the waveform
        for(int i = 0 ; i < bv.getAudioBuffer().size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], bv.getAudioBuffer().get(i), 0.1f);
            bv.line(i, 0 - lerpedBuffer[i] * width/6, i, 0 + lerpedBuffer[i] * width/6 );
            bv.line(i, height - lerpedBuffer[i] * width/6, i, height + lerpedBuffer[i] * width/6 );
        } 
        

        //putting shaped in center of the screen
        bv.translate(width/2, height/2);


        //rotation for the pyramids
        bv.rotateX(angle);
        bv.rotateZ(angle);

        //constructing first pyramid
        bv.beginShape();
        bv.vertex(-size, -size, -size);
        bv.vertex(size, -size, -size);
        bv.vertex(   0,    0,  size);

        bv.vertex( size, -size, -size);
        bv.vertex( size,  size, -size);
        bv.vertex(   0,    0,  size);
   
        bv.vertex( size, size, -size);
        bv.vertex(-size, size, -size);
        bv.vertex(   0,   0,  size);
     
        bv.vertex(-size,  size, -size);
        bv.vertex(-size, -size, -size);
        bv.vertex(   0,    0,  size);

        bv.vertex(-size,  size, -size);
        bv.vertex(-size, -size, -size);
        bv.vertex(   0,    0,  size);
        bv.endShape();
        
        // constructing second pyramid
        bv.beginShape();
        bv.vertex(size, size, size);
        bv.vertex( -size, size, size);
        bv.vertex(   0,    0,  -size);

        bv.vertex( -size, size, size);
        bv.vertex( -size, -size, size);
        bv.vertex(   0,    0,  -size);

        bv.vertex( -size, -size, size);
        bv.vertex(size, -size, size);
        bv.vertex(   0,   0,  -size);

        bv.vertex(size,  -size, size);
        bv.vertex(size, size, size);
        bv.vertex(   0,    0,  -size);
        
        bv.vertex(size,  -size, size);
        bv.vertex(size, size, size);
        bv.vertex(   0,    0,  -size);
        bv.endShape(); 

        bv.strokeWeight(1);
        bv.fill(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        bv.box(size * bv.getSmoothedAmplitude());

        angle += 0.01f;
    }

}
