import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SquareIntoSquares {

    public static void main(String[] args) {

        assertEquals("1 2 4 10", decompose(11));
        assertEquals("1 3 5 8 49", decompose(50));
    }

    private static String decompose(long n) {
        List<Long> powLongs = decompose(n, n * n);
        if (powLongs != null)
            return powLongs.stream().limit(powLongs.size() - 1)
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
        return null;
    }
    private static List<Long> decompose(long n, long remain){
        // basic case
        if(remain == 0){
            List<Long> r = new ArrayList<>();
            r.add(n);
            return r;
        }
        // iterate all element less than n
        for(long i = n - 1 ; i > 0; i--){
            if((remain - i * i) >= 0){
                List<Long> r = decompose(i, (remain - i * i));

                // only get the answer
                if(r != null){
                    r.add(n);
                    return r;
                }
            }
        }

        return null;
    }
}
