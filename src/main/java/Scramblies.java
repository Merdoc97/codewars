import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
 * <p>
 * Notes:
 * <p>
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered
 * Input strings s1 and s2 are null terminated.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 */
public class Scramblies {

    public static void main(String[] args) {
        System.out.println("Fixed Tests scramble");
        testing(Scramblies.scramble("rkqodlw", "world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt", "codewars"), true);
        testing(Scramblies.scramble("katas", "steak"), false);
        testing(Scramblies.scramble("scriptjavx", "javascript"), false);
        testing(Scramblies.scramble("scriptingjava", "javascript"), true);
        testing(Scramblies.scramble("scriptsjava", "javascripts"), true);
        testing(Scramblies.scramble("javscripts", "javascript"), false);
        testing(Scramblies.scramble("aabbcamaomsccdd", "commas"), true);
        testing(Scramblies.scramble("commas", "commas"), true);
        testing(Scramblies.scramble("sammoc", "commas"), true);
    }

    private static boolean scramble(String str1, String str2) {
        List<Character> first = str1.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.toList());

        List<Character> second = str2.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.toList());
        for (int i = 0; i < second.size(); i++) {
            Character ch = second.get(i);
            if (!first.isEmpty() && first.contains(ch)) {
                for (int s = 0; s < first.size(); s++) {
                    if (first.get(s).equals(ch)) {
                        first.remove(s);
                        break;
                    }
                }

            }
        }

        return str1.length() - first.size() == second.size();
    }

    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }
}
