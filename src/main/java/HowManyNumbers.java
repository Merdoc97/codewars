import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class HowManyNumbers {

    public static List<Long> findAll(final int sumDigits, final int numDigits) {

        List<Integer> res = IntStream.range(getMinRange(numDigits), getMaxRange(numDigits) + 1)
                .parallel()
                .filter(integer -> isEqual(sumDigits, integer))
                .mapToObj(value -> value)
                .collect(Collectors.toList());

        return Stream.of(res.size(),
                res.isEmpty() ? 0 : res.get(0),
                res.isEmpty() ? 0 : res.get(res.size() - 1))
                .map(Number::longValue)
                .filter(aLong -> aLong != 0)
                .collect(Collectors.toList());
    }

    private static int getMinRange(long numDigits) {
        return Integer.parseInt("1".concat(IntStream.range(0, (int) numDigits - 1)
                .mapToObj(value -> value)
                .map(integer -> "0")
                .collect(Collectors.joining(""))));
    }

    private static int getMaxRange(long numDigits) {
        return Integer.parseInt("9".concat(IntStream.range(0, (int) numDigits - 1)
                .mapToObj(value -> value)
                .map(integer -> "9")
                .collect(Collectors.joining(""))));
    }

    private static boolean isEqual(int sumDigits, int number) {
        if (getUniqueNumber(number) == number) {
            long sum = Arrays.stream(String.valueOf(number).split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();
            return sumDigits == sum;
        }
        return false;
    }

    private static int getUniqueNumber(long number) {
        return Integer.parseInt(Arrays.stream(String.valueOf(number).split(""))
                .sorted()
                .collect(Collectors.joining()));
    }

    public static void main(String... args) {
        long start = System.currentTimeMillis();
        assertEquals(100, getMinRange(3));
        assertEquals(10, getMinRange(2));
        assertEquals(999, getMaxRange(3));
        assertEquals(99, getMaxRange(2));
        assertEquals(9, getMaxRange(1));

        assertEquals(Arrays.asList(8L, 118L, 334L), HowManyNumbers.findAll(10, 3));
        assertEquals(Arrays.asList(1L, 999L, 999L), HowManyNumbers.findAll(27, 3));
        assertEquals(new ArrayList<Long>(), HowManyNumbers.findAll(84, 4));
        assertEquals(Arrays.asList(123L, 116999L, 566666L), HowManyNumbers.findAll(35, 6));
        assertEquals(Arrays.asList(94L, 119999L, 666677L), HowManyNumbers.findAll(38, 6));
        assertEquals(Arrays.asList(10L, 39999L, 78888L), HowManyNumbers.findAll(39, 5));


        long end = System.currentTimeMillis();
        System.out.println("time spend " + (end - start));


    }
}
