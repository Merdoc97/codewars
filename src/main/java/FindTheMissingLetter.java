import static org.junit.Assert.assertEquals;

/**
 * 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
 * or from 97 +25=122
 * in Upper case starts from 65 +25=87
 */
public class FindTheMissingLetter {

    public static void main(String[] args) {
        assertEquals('e', findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));

        System.out.println(findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        System.out.println(findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
    }

    public static char findMissingLetter(char[] array) {
        char result = 0;
        for (int i = 1; i < array.length; i++) {
            int previous = array[i - 1];
            int current = array[i];
            if (current - previous != 1) {
                result = (char) (previous + 1);
                break;
            }
        }
        return result;

    }
}
