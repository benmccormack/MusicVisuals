package c19459424;

import processing.core.*;

public class pyramidVisual {
    MyVisual mv;
    float width;
    float height;
    float[] lerpedBuffer;

    public pyramidVisual(MyVisual mv)
    {
        this.mv = mv; 
        width = this.mv.width;
        height = this.mv.height;
        lerpedBuffer = new float[mv.width];
    }

    float angle = 0;
  
    float size = 100; //size variable for vertices and box

    public void render()
    {
        mv.colorMode(PApplet.HSB);
        mv.lights();
        mv.noFill();
        mv.strokeWeight(4);
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);

        //generating the waveform
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], mv.getAudioBuffer().get(i), 0.1f);
            mv.line(i, 0 - lerpedBuffer[i] * width/6, i, 0 + lerpedBuffer[i] * width/6 );
            mv.line(i, height - lerpedBuffer[i] * width/6, i, height + lerpedBuffer[i] * width/6 );
        } 
        

        //putting shaped in center of the screen
        mv.translate(width/2, height/2);


        //rotation for the pyramids
        mv.rotateX(angle);
        mv.rotateZ(angle);

        //constructing first pyramid
        mv.beginShape();
        mv.vertex(-size, -size, -size);
        mv.vertex(size, -size, -size);
        mv.vertex(   0,    0,  size);

        mv.vertex( size, -size, -size);
        mv.vertex( size,  size, -size);
        mv.vertex(   0,    0,  size);
   
        mv.vertex( size, size, -size);
        mv.vertex(-size, size, -size);
        mv.vertex(   0,   0,  size);
     
        mv.vertex(-size,  size, -size);
        mv.vertex(-size, -size, -size);
        mv.vertex(   0,    0,  size);

        mv.vertex(-size,  size, -size);
        mv.vertex(-size, -size, -size);
        mv.vertex(   0,    0,  size);
        mv.endShape();
        
        // constructing second pyramid
        mv.beginShape();
        mv.vertex(size, size, size);
        mv.vertex( -size, size, size);
        mv.vertex(   0,    0,  -size);

        mv.vertex( -size, size, size);
        mv.vertex( -size, -size, size);
        mv.vertex(   0,    0,  -size);

        mv.vertex( -size, -size, size);
        mv.vertex(size, -size, size);
        mv.vertex(   0,   0,  -size);

        mv.vertex(size,  -size, size);
        mv.vertex(size, size, size);
        mv.vertex(   0,    0,  -size);
        
        mv.vertex(size,  -size, size);
        mv.vertex(size, size, size);
        mv.vertex(   0,    0,  -size);
        mv.endShape(); 

        mv.strokeWeight(1);
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.box(size * mv.getSmoothedAmplitude());

        angle += 0.01f;
    }

}
