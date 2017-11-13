/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memclicker;

/**
 *
 * @author pp2
 * Thread that adding amount of memes to total count
 */
public class AdderThread extends Thread {
    private MemeCounter counter;
    private int addAmount;
    
    public AdderThread(MemeCounter counter, int addAmount){
        this.counter = counter;
        this.addAmount = addAmount;
    }
    
    @Override
    public void run() {
        while (true){
           counter.increaseCounter(addAmount);
          try{
           Thread.sleep(1000);}
          catch (InterruptedException ex){
              //nothing
          }
        }
    }
    
}
