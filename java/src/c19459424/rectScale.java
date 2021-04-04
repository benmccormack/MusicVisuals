package c19459424;

import processing.core.*;

public class rectScale{
    MyVisual mv;
    float width;
    float height;
    float angle = 0;

    public rectScale(MyVisual mv)
    {
        this.mv = mv;
        width = (float)this.mv.width;
        height = (float)this.mv.height;
    }

    	
    void setup() {  
    }

    public void render(){
        /*
        mv.noFill();
        mv.stroke(255);
        mv.translate(width/2+12, height/2);
        mv.box(20, 20, 20);
        mv.scale((float)2.5, (float)2.5, (float)2.5);
        mv.box(20, 20, 20);
        */
        //mv.translate(width/2, height/2);

        
        mv.strokeWeight(25);
        mv.translate(width/2, height/2);
        //mv.noFill();
        mv.fill(255);
        mv.stroke(255);
        for(int i = 0; i < 8; i++)
        {
            //mv.scale((float)0.95);
            mv.rotate(angle);
            //mv.rect(100,100,height - height/2,height - height/2);
            mv.rect(100,100,height,height);
            //mv.ellipse(height/2, width/2, 300, 500);
            //mv.line(250, 250, 500, 500);
                
        }
        angle+=0.01;
        
    }
}