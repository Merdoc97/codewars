import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ShortestWord {

    public static void main(String[] args) {
        assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, findShort("turns out random test cases are easier than writing out basic ones"));
        assertEquals(0, findShort(null));
        assertEquals(0, findShort(""));
    }

    private static int findShort(String s) {
        if (s == null || s.isEmpty())
            return 0;
        return Stream.of(s.split(" "))
                .mapToInt(String::length)
                .min().orElse(0);
    }
}
