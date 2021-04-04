package c19459424;

import ie.tudublin.*;

public class MyVisual extends Visual {
    waveform wf;
    rectScale rs;
    rectSize rects;
    trianglevisual tv;

    public void settings()
    {
        size(1024,720, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("heroplanet.mp3");   
        
        // Call this instead to read audio from the microphone
        //startListening(); 
        wf = new waveform(this);
        rs = new rectScale(this);
        rects = new rectSize(this);
        tv = new trianglevisual(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();     
        wf.render();
        //rs.render();
        //rects.render();
        //tv.render();
       
    }
}
