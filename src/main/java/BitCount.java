import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class BitCount {

    public static BigInteger countOnes(long left, long right) {
        return IntStream.range((int) left, (int) right + 1)
                .parallel()
                .mapToObj(Long::valueOf)
                .flatMap(BitCount::getNonZeroBits)
                .reduce(BigInteger::add).orElse(BigInteger.valueOf(0));
    }

    private static Stream<BigInteger> getNonZeroBits(long value) {
        return Arrays.stream(Long.toBinaryString(value).replaceAll("0", "").split(""))
                .map(BigInteger::new);
    }



    public static void main(String[] args) {
        assertEquals(new BigInteger("7"), BitCount.countOnes(5, 7));
        assertEquals(new BigInteger("51"), BitCount.countOnes(12, 29));


    }
}
