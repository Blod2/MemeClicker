/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memclicker;

import javax.swing.JLabel;

/**
 *
 * @author pp2
 * Thread that refreshing total meme counter on screen. 
 */
public class MemeOutputThread extends Thread {
    private MemeCounter counter;
    private JLabel labelOutput;
    private JLabel mps;
    private volatile boolean StopFlag = true;
    private int[] array;
    private int[] arrayofvalues = {1,4,6,10,14,16,20};
    
    public MemeOutputThread(MemeCounter counter,JLabel labeloutput, JLabel mps, int[] array){
        this.counter = counter;
        this.labelOutput = labeloutput;
        this.mps = mps;
        this.array = array;
    }
    
    private void memeOutput(){
        labelOutput.setText(Long.toString(counter.getCounter()));
        int currentMps = 0;
        for (int i=0; i<7; i++){
            currentMps+=(array[i]*arrayofvalues[i]);
        }
        mps.setText(Integer.toString(currentMps));
    }
    
    public void stopThread(){
        StopFlag = false;
    }
    
    @Override
    public void run() {
        while (StopFlag){
            memeOutput();
        }
    }
    
}
