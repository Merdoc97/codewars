import static org.junit.Assert.assertEquals;

/**
 * You are going to be given a word. Your job is to return the middle character of the word. If the word's length is odd, return the middle character. If the word's length is even, return the middle 2 characters.
 * <p>
 * #Examples:
 * Kata.getMiddle("test") should return "es"
 * <p>
 * Kata.getMiddle("testing") should return "t"
 * <p>
 * Kata.getMiddle("middle") should return "dd"
 * <p>
 * Kata.getMiddle("A") should return "A"
 * #Input
 * <p>
 * A word (string) of length 0 < str < 1000 (In javascript you may get slightly more than 1000 in some test cases due to an error in the test cases). You do not need to test for this. This is only here to tell you that you do not need to worry about your solution timing out.
 * <p>
 * #Output
 * <p>
 * The middle character(s) of the word represented as a string.
 */
public class GetTheMiddleCharacter {

    public static void main(String[] args) {

        System.out.println("expected es , actual is " + getMiddle("test"));
        System.out.println("expected dd , actual is " + getMiddle("middle"));
        System.out.println("expected t , actual is " + getMiddle("testing"));
        System.out.println("expected A , actual is " + getMiddle("A"));
        assertEquals("es", getMiddle("test"));
        assertEquals("dd", getMiddle("middle"));
        assertEquals("t", getMiddle("testing"));
        assertEquals("A", getMiddle("A"));
    }

    private static String getMiddle(String word) {
        if (word.length() == 2 || word.length() == 1)
            return word;
        if (word.length() % 2 == 0) {
            return word.substring((word.length() / 2) - 1, word.length() / 2 + 1);
        }
        return word.substring(word.length() / 2, (word.length() / 2) + 1);
    }
}
