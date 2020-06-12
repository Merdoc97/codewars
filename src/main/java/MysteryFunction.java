import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MysteryFunction {
    private static List<String> start = List.of("0", "1");

    public static long mystery(long n) {
        if (n > -1 && n < Long.MAX_VALUE) {
            return Long.parseLong(getCollection(n, start).get((int) n), 2);
        }
        return -1;
    }

    public static long mysteryInv(long n) {
        if (n > -1 && n < Long.MAX_VALUE) {
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                long res = mystery(i);
                if (res == n)
                    return i;
            }

        }
        return -1;
    }

    public static String nameOfMystery() {
        return "";
    }

    private static List<String> getCollection(long number, List<String> first) {
        if (number == 1 || number == 0) {
            return first;
        }
        LinkedList<String> res = Stream.concat(addZeroBitFromLeftToRight(first), addOneBitFromRightToLeft(first))
                .collect(Collectors.toCollection(LinkedList::new));
        return getCollection(--number, res);
    }


    private static Stream<String> addZeroBitFromLeftToRight(List<String> collection) {
        return collection.parallelStream()
                .map(s -> "0" + s);
    }

    private static Stream<String> addOneBitFromRightToLeft(List<String> collection) {
        return Stream.iterate(collection.size() - 1, n -> n - 1)
                .limit(collection.size())
                .parallel()
                .map(integer -> "1" + (collection.get(integer)));
    }

    public static void main(String[] args) {

        assertEquals("mystery(0) ", 0, MysteryFunction.mystery(0));
        assertEquals("mystery(0) ", 1, MysteryFunction.mystery(1));
        assertEquals("mystery(6) ", 5, MysteryFunction.mystery(6));
        assertEquals("mystery(9) ", 13, MysteryFunction.mystery(9));
        assertEquals("mystery(19) ", 26, MysteryFunction.mystery(19));

        assertEquals("mysteryInv(5)", 6, MysteryFunction.mysteryInv(5));
        assertEquals("mysteryInv(13)", 9, MysteryFunction.mysteryInv(13));
        assertEquals("mysteryInv(26)", 19, MysteryFunction.mysteryInv(26));
    }
}
