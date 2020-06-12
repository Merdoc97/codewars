import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Given the triangle of consecutive odd numbers:
 * 1
 * 3     5
 * 7     9    11
 * 13    15    17    19
 * 21    23    25    27    29
 * Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
 * rowSumOddNumbers(1); // 1
 * rowSumOddNumbers(2); // 3 + 5 = 8
 */
public class SumOfOddNumbers {

    public static void main(String[] args) {
        System.out.println("expected 1: actual is: " + rowSumOddNumbers(1));
        System.out.println("expected 8: actual is: " + rowSumOddNumbers(2));
        System.out.println("expected 27: actual is: " + rowSumOddNumbers(3));
        System.out.println("expected 64: actual is: " + betterSolution(4));
        System.out.println("expected 74088: actual is: " + rowSumOddNumbers(42));
        assertEquals(1, rowSumOddNumbers(1));
        assertEquals(74088, rowSumOddNumbers(42));
    }

    private static int rowSumOddNumbers(int n) {
        int oddNumber = IntStream.range(0, n + 1).sum();
        return IntStream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 != 0)
                .limit(oddNumber)
                .skip(oddNumber - n)
                .sum();
    }
    /* sum of consequent M numbers is (M+1)M/2, so
     * we may know how many numbers were below
     * our ROW : numbersBelow = ((n-1)*(n))/2.
     * Now we may calculate first number in row:
     * firstNumberInRow = 2*numbersBelow+1.
     * So, firstNumberInRow = n*n-n+1 and
     * last number in ROW is n*n-n+1 + 2(n-1).
     * Let assume that last number before row is
     * x1 and last number in row is x2. It's known
     * that 1+3+5+...+(2k-1) = k*k.
     * Sum in row must be x2*x2 - x1*x1.
     // OUR x1 = (n*n-n)/2 and x2 = (n*n+n)/2.
     * After some simplification: SUM = n*n*n. */
    private static int betterSolution(int n) {
        return n*n*n;
    }
}
