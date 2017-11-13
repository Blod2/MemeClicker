/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memclicker;

/**
 *
 * @author pp2
 * Class that ceeps current meme counter.
 */
public class MemeCounter {
    
    private long Counter = 0L;
    private long totalCounter = 0L;
    
    public synchronized void increaseCounter(long amount){
        Counter+=amount;
        totalCounter+=amount;
    }
    
    public synchronized void decreaseCounter(long amount){
        Counter-=amount;
    }
    
    public synchronized long getCounter(){
        return Counter;
    }
    
    public synchronized long getTotalCounter(){
        return totalCounter;
    }
    
}
