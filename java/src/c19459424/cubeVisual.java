package c19459424;

import ie.tudublin.MyVisual;
import processing.core.*;

public class cubeVisual extends MyVisual{
    public void render(){
        //calculateAverageAmplitude();
        float boxSize = 50 + (200 * getSmoothedAmplitude()); 
        box(boxSize);
    }
} 