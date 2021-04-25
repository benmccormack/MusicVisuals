package c19459424;

import ie.tudublin.*;

public class BensVisual extends Visual {
    waveform wf;
    rectSize rects;
    freqBars fb;
    cubeVisual cv;
    pyramidVisual pv;
    radialWaveform rw;
    menu menu;

    int which = 0;

    public void settings()
    {
        size(1024,720, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("HDIGH.mp3");   
        
        wf = new waveform(this);
        rects = new rectSize(this);
        fb = new freqBars(this);
        cv = new cubeVisual(this);
        pv = new pyramidVisual(this);
        rw = new radialWaveform(this);
        menu = new menu(this);
    }

    public void keyPressed()
    {
        /*
        if (keyCode == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        */

        if (keyCode >= '0' && keyCode <= '6') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().rewind();
                getAudioPlayer().play();
            }
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
        
        switch(which)
        {
            case 0:
                menu.render();
                break;
            case 1:
                wf.render();
                break;

            case 2:
                cv.render();
                break;

            case 3:
                pv.render();
                break;
            
            case 4:
                rw.render();
                break;

            case 5:
                fb.render();
                break;

            case 6:
                rects.render();
                break;
        }
        /*
        if(key == '1')
        {
            wf.render();
        }

        if(key == '2')
        {
            cv.render();
        }

        if(key == '3')
        {
            pv.render();
        }

        if(key == '4')
        {
            rw.render();
        }

        if(key == '5')
        {
            fb.render();
        }

        if(key == '6')
        {
            rects.render(); 
        }
        */
    }
}
