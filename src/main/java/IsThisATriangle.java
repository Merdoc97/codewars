import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class IsThisATriangle {

    public static void main(String[] args) {
        assertEquals(true, isTriangle(1, 2, 2));
        assertEquals(false, isTriangle(7, 2, 2));
    }

    public static boolean isTriangle(int a, int b, int c) {
        List<Integer> sides = Stream.of(a, b, c)
                .filter(number -> number > 0)
                .collect(Collectors.toList());
        if (sides.size() != 3)
            return false;
        Collections.sort(sides);
        return sides.get(0) + sides.get(1) > sides.get(2);
    }
}
