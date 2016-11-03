/*
 * using current FS gen method, it costs 93ms to get 1000 Fib numbers. 
 * 
 * 
 */
package Sequence;

/**
 *
 * @author YNZ
 */
public class UsingFSGen {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        FibonacciSequence.generate(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("time(ms): " + (endTime-currentTime));
        
    }
    
}
