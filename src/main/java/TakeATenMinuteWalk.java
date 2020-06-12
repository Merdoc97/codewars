import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * result is
 * x=n-s
 * y=e-w
 */
public class TakeATenMinuteWalk {

    public static void main(String[] args) {
        assertEquals("Should return true", true, isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        assertEquals("Should return false", false, isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}));
        assertEquals("Should return false", false, isValid(new char[]{'w'}));
        assertEquals("Should return false", false, isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
    }

    public static boolean isValid2(char[] walk) {

        if (walk.length == 10) {
            int n = 0;
            int s = 0;
            int e = 0;
            int w = 0;
            for (int i = 0; i < walk.length; i++) {
                switch (walk[i]) {
                    case 'n':
                        n++;
                        break;
                    case 's':
                        s++;
                        break;
                    case 'e':
                        e++;
                        break;
                    case 'w':
                        w++;
                        break;
                }
            }
            return n - s == 0 && e - w == 0;

        } else return false;

    }

    public static boolean isValid(char[] walk) {
        if (walk.length == 10) {
            Map<String, Long> res = new String(walk).chars()
                    .mapToObj(chars -> String.valueOf((char) chars))
                    .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
            return res.getOrDefault("n", 0l) - res.getOrDefault("s", 0l) == 0
                    && res.getOrDefault("e", 0l) - res.getOrDefault("w", 0l) == 0;
        }
        return false;
    }
}
