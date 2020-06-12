import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringMerger {

    public static boolean isMerge(String s, String part1, String part2) {

        if (s.length() != (part1.length() + part2.length()))
            return false;
        if (part1.equals(part2) && !part1.isEmpty() && !part2.isEmpty())
            return false;

        Deque<String> mainQueue = Arrays.stream(s.split("")).filter(s1 -> !s1.isEmpty()).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> part1Queue = Arrays.stream(part1.split("")).filter(s1 -> !s1.isEmpty()).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> part2Queue = Arrays.stream(part2.split("")).filter(s1 -> !s1.isEmpty()).collect(Collectors.toCollection(ArrayDeque::new));
        int size = mainQueue.size();
        for (int i = 0; i < size; i++) {
            String expected = mainQueue.pollFirst();
            int marker = 0;
            if (!part1Queue.isEmpty() && expected.equals(part1Queue.getFirst())) {
                part1Queue.pollFirst();
                marker++;
            }
            if (!part2Queue.isEmpty() && expected.equals(part2Queue.getFirst()) && marker == 0) {
                part2Queue.pollFirst();
            }
        }
        return mainQueue.size() == (part1Queue.size() + part2Queue.size());
    }

    public static void main(String[] args) {
        assertTrue("codewars can be created from code and wars", StringMerger.isMerge("codewars", "code", "wars"));
        assertFalse("codewars can be created from code and wasr", StringMerger.isMerge("codewars", "code", "wasr"));
        assertTrue("codewars can be created from cdwr and oeas", StringMerger.isMerge("codewars", "cdwr", "oeas"));
        assertFalse("Codewars are not codwars", StringMerger.isMerge("codewars", "cod", "wars"));
        assertTrue("codewars are codewars", StringMerger.isMerge("codewars", "codewars", ""));
        assertFalse("codewars is not code + code", StringMerger.isMerge("codewars", "code", "code"));
    }
}
