import org.junit.Assert;

import java.util.stream.IntStream;

/**
 * Given two integers a and b, which can be positive or negative, find the sum of all the numbers between including them too and return it. If the two numbers are equal return a or b.
 * <p>
 * Note: a and b are not ordered!
 * Examples
 * GetSum(1, 0) == 1   // 1 + 0 = 1
 * GetSum(1, 2) == 3   // 1 + 2 = 3
 * GetSum(0, 1) == 1   // 0 + 1 = 1
 * GetSum(1, 1) == 1   // 1 Since both are same
 * GetSum(-1, 0) == -1 // -1 + 0 = -1
 * GetSum(-1, 2) == 2  // -1 + 0 + 1 + 2 = 2
 */
public class BeginnerSeries {


    public static void main(String[] args) {
        Assert.assertEquals(1, getSum(1, 0));
        Assert.assertEquals(3, getSum(1, 2));
        Assert.assertEquals(1, getSum(0, 1));
        Assert.assertEquals(1, getSum(1, 1));
        Assert.assertEquals(-1, getSum(-1, 0));
        Assert.assertEquals(2, getSum(-1, 2));

        Assert.assertEquals(1, getSumStream(1, 0));
        Assert.assertEquals(3, getSumStream(1, 2));
        Assert.assertEquals(1, getSumStream(0, 1));
        Assert.assertEquals(1, getSumStream(1, 1));
        Assert.assertEquals(-1, getSumStream(-1, 0));
        Assert.assertEquals(2, getSumStream(-1, 2));
    }


    private static int getSum(int a, int b) {
        int result = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            result = result + i;
        }
        return result;
    }

    private static int getSumStream(int a, int b) {
        return IntStream.range(Math.min(a, b), Math.max(a, b) + 1).sum();
    }
}
