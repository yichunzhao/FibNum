/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sequence;

import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author YNZ
 */
public class FibonacciSequenceTest {

    public FibonacciSequenceTest() {
    }

    @Test
    public void testGenerate() {
        Integer[] fs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
        BigInteger[] expected = new BigInteger[fs.length];

        for (int i = 0; i < expected.length; i++) {
            expected[i] = new BigInteger(fs[i].toString());
        }

        BigInteger[] actuals = FibonacciSequence.generate(fs.length);
        Assert.assertArrayEquals(expected, actuals);

    }

}
