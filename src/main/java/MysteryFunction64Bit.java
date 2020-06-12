import static org.junit.Assert.assertEquals;

public class MysteryFunction64Bit {

    public static long mystery(long n) {
        if (n > -1 && n < Long.MAX_VALUE) {
            return grayCode(n);
        }
        return -1;
    }

    static long grayCode(long n) {
        return n ^ (n >> 1);
    }

    public static long mysteryInv(long gray) {
        long bin = 0;
        for (bin = 0; gray > 0; gray >>= 1) {
            bin ^= gray;
        }
        return bin;
    }

    public static String nameOfMystery() {
        return "gray code";
    }

    public static void main(String[] args) {

        assertEquals("mystery(0) ", 0, MysteryFunction64Bit.mystery(0));
        assertEquals("mystery(0) ", 1, MysteryFunction64Bit.mystery(1));
        assertEquals("mystery(6) ", 5, MysteryFunction64Bit.mystery(6));
        assertEquals("mystery(9) ", 13, MysteryFunction64Bit.mystery(9));
        assertEquals("mystery(19) ", 26, MysteryFunction64Bit.mystery(19));
        assertEquals("mystery(8070189064100171895) ", 6341238885029886028L, MysteryFunction64Bit.mystery(8070189064100171895L));


        assertEquals("mysteryInv(5)", 6, MysteryFunction64Bit.mysteryInv(5));
        assertEquals("mysteryInv(13)", 9, MysteryFunction64Bit.mysteryInv(13));
        assertEquals("mysteryInv(26)", 19, MysteryFunction64Bit.mysteryInv(26));

    }
}
