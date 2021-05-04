package c19459424;

import processing.core.*;

public class pyramidVisual extends waveform{
    float width;
    float height;

    public pyramidVisual(BensVisual bv)
    {
        super(bv);
    }

    float angle = 0;
  
    float size = 100; //size variable for vertices and box

    @Override
    public void render()
    {   
        bv.lights();
        bv.noFill();
        bv.strokeWeight(4);
        bv.stroke(PApplet.map(bv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);  

        bv.pushMatrix();
        //putting shaped in center of the screen
        bv.translate(bv.width/2f, bv.height/2f);


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
        bv.popMatrix();

        bv.translate(0, -bv.height / 2f);
        super.render();

        bv.translate(0, bv.height);
        super.render();
    }

}