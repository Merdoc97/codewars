import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class NextBiggerNumberWithTheSameDigits {

    public static void main(String[] args) {
        assertEquals(-1, nextBiggerNumber(9));
        assertEquals(21, nextBiggerNumber(12));
        assertEquals(531, nextBiggerNumber(513));
        assertEquals(213, nextBiggerNumber(132));
        assertEquals(2071, nextBiggerNumber(2017));
        assertEquals(441, nextBiggerNumber(414));
        assertEquals(414, nextBiggerNumber(144));


        assertEquals(1234567908, nextBiggerNumber(1234567890));

        assertEquals(9876543201l,nextBiggerNumber(9876543120l));
//
    }

    private static long nextBiggerNumber(long n) {
        char[] in = String.valueOf(n).toCharArray();
        char[]res=findChars(in);
        if (res!=null) {
            long result = getFromCharArray(res);
            return result > n ? result : -1;
        }
        return -1;
    }

    private static char[] findChars(char[] previousChar) {
        long previous = getFromCharArray(previousChar);
        long current =getMaxvalue(previousChar);
        for (long i = previous+1; i <= current; i++) {
            if (containsTheSameNumbers(previousChar,String.valueOf(i).toCharArray())) {
                boolean res=containsTheSameNumbers(previousChar,String.valueOf(i).toCharArray());
                return String.valueOf(i).toCharArray();
            }
        }
        return null;
    }


    private  static Long getMaxvalue(char[]array){
        return Long.parseLong(new String(array).chars().mapToObj(value -> (char)value)
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining("")));

    }


    private static boolean containsTheSameNumbers(char[] in,char[]searching) {
        List<Integer>first=new String(in).chars().mapToObj(value -> (char)value)
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        List<Integer>second=new String(searching).chars().mapToObj(value -> (char)value)
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(first);
        Collections.sort(second);
        return first.equals(second);

    }

    private static Long getFromCharArray(char[] input) {
        return Long.parseLong(Stream.of(input)
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }


}
