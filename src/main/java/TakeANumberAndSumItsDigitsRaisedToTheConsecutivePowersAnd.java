import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/**
 * The number 89 is the first integer with more than one digit that fulfills the property partially introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.
 * <p>
 * In effect: 89 = 8^1 + 9^2
 * <p>
 * The next number in having this property is 135.
 * <p>
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 * <p>
 * We need a function to collect these numbers, that may receive two integers a, b that defines the range [a, b] (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.
 * <p>
 * Let's see some cases:
 * <p>
 * sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * <p>
 * sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
 * If there are no numbers of this kind in the range [a, b] the function should output an empty list.
 * <p>
 * sum_dig_pow(90, 100) == []
 */
public class TakeANumberAndSumItsDigitsRaisedToTheConsecutivePowersAnd {


    public static void main(String[] args) {
        testing(1, 10, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100, new long[]{89});
        testing(90, 100, new long[]{});
        testing(90, 150, new long[]{135});
        testing(50, 150, new long[]{89, 135});
        testing(10, 150, new long[]{89, 135});
    }

    private static List<Long> sumDigPow(long a, long b) {

        return LongStream.range(a, b + 1)
                .filter(value -> {
                    char[] chars = String.valueOf(value).toCharArray();
                    long res = 0;
                    for (int i = 0; i < chars.length; i++) {
                        res = (long) (res + (Math.pow((long) Character.digit(chars[i], 10), i + 1)));
                    }
                    return res == value;
                })
                .boxed()
                .collect(Collectors.toList());

    }

    private static void testing(long a, long b, long[] res) {
        assertEquals(Arrays.toString(res),
                Arrays.toString(sumDigPow(a, b).toArray()));
    }
}
