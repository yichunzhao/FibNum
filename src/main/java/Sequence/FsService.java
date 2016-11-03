/*
 *  Add up all the even elements of the fibonacci sequence below 1000
 */
package Sequence;

import java.math.BigInteger;

/**
 *
 * @author YNZ
 */
public class FsService {

    private static final BigInteger B_2 = BigInteger.valueOf(2);
    private static final BigInteger B_0 = BigInteger.valueOf(0);

    public static BigInteger sumEvenFs(int n) {
        BigInteger sum = B_0;
        BigInteger[] fs = FibonacciSequence.generate(n);

        for (BigInteger f : fs) {
            if (f.remainder(B_2).compareTo(B_0) == 0) {
                sum = sum.add(f);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BigInteger sum = FsService.sumEvenFs(1000);
        System.out.println("" + sum.toString());

    }
}
