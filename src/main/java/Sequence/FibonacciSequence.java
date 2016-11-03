/*
 * Write a recursive function that calculates the fibonacci sequence up to 1000
 *  
 */
package Sequence;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author YNZ
 */
public class FibonacciSequence {

    private static BigInteger calculate(int n, BigInteger[] fs) {

        if (n == 0) {
            fs[n] = new BigInteger("0");
            return fs[n];
        }

        if (n == 1 || n == 2) {
            fs[n] = new BigInteger("1");
            return fs[n];
        }

        fs[n - 1] = calculate(n - 1, fs);

        return fs[n - 1].add(fs[n - 2]);
    }

    public static BigInteger[] generate(int n) {
        BigInteger[] fs = new BigInteger[n + 1];
        for (int i = 0; i < fs.length; i++) {
            fs[i] = calculate(i, fs);
        }
        return fs;
    }

    public static void print(int n) {
        System.out.println(Arrays.toString(generate(n)));
    }

    public static void main(String[] args) {
        print(1000);

    }

}
