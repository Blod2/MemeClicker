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
    private JLabel rank;
    private volatile boolean StopFlag = true;
    private int[] array;
    private int[] arrayofvalues = {1,4,6,10,14,16,20};
    private String[] ranks ={
        "Новичек",
        "Начинающий мемодел",
        "Лягушка Пэпэ",
        "Кермит",
        "Пожиратель мемасиков",
        "КЕК",
        "Краб",
        "Павел Дуров",
        "Чертов засранец как ты это делаешь",
        "over 9000",
        "Тот самый мэмный Б-г"
    };
    
    public MemeOutputThread(MemeCounter counter,JLabel labeloutput, JLabel mps, int[] array, JLabel rank){
        this.counter = counter;
        this.labelOutput = labeloutput;
        this.mps = mps;
        this.array = array;
        this.rank = rank;
    }
    
    private void memeOutput(){
        labelOutput.setText(Long.toString(counter.getCounter()));
        int currentMps = 0;
        for (int i=0; i<7; i++){
            currentMps+=(array[i]*arrayofvalues[i]);
        }
        mps.setText(Integer.toString(currentMps));
        rankCheck();
    }
    
    private void rankCheck(){
        long c = counter.getTotalCounter()/100000;
        switch ((int)c){
            case 0: rank.setText(ranks[0]); break;
            case 1: rank.setText(ranks[1]); break;
            case 2: rank.setText(ranks[2]); break;
            case 3: rank.setText(ranks[3]); break;
            case 4: rank.setText(ranks[4]); break;
            case 5: rank.setText(ranks[5]); break;
            case 6: rank.setText(ranks[6]); break;
            case 7: rank.setText(ranks[7]); break;
            case 8: rank.setText(ranks[8]); break;
            case 9: rank.setText(ranks[9]); break;
            case 10: rank.setText(ranks[10]); break;
        }
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
