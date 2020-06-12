import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings. All words must have their first letter capitalized without spaces.
 *
 * For instance:
 *
 * camelCase("hello case"); // => "HelloCase"
 * camelCase("camel case word"); // => "CamelCaseWord"
 */
public class CamelCaseMethod {

    public static void main(String[] args) {
        assertEquals("TestCase", camelCase("test case"));
        assertEquals("CamelCaseMethod", camelCase("camel case method"));
        assertEquals("CamelCaseWord", camelCase(" camel case word"));
        assertEquals("SayHello", camelCase("say hello "));
        assertEquals("Z", camelCase("z"));
        assertEquals("AbC", camelCase("ab  c"));
        assertEquals("", camelCase(""));
    }

    private static String camelCase(String str) {
        return Arrays.stream(str.split(" "))
                .map(s -> {
                    if (s.length()>1) {
                        return s.substring(0, 1).toUpperCase().concat(s.substring(1));
                    }
                    return s.toUpperCase();
                })
                .filter(s -> !s.equals(" "))
                .collect(Collectors.joining(""));
    }
}
