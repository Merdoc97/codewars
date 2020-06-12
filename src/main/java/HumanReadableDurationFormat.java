import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
 * <p>
 * The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 * <p>
 * It is much easier to understand with an example:
 * <p>
 * TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
 * TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
 * For the purpose of this Kata, a year is 365 days and a day is 24 hours.
 * <p>
 * Note that spaces are important.
 * <p>
 * Detailed rules
 * The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
 * <p>
 * The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.
 * <p>
 * A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
 * <p>
 * Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
 * <p>
 * A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
 * <p>
 * A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
 */
public class HumanReadableDurationFormat {

    public static void main(String[] args) {
        assertEquals("1 second", formatDuration(1));
        assertEquals("1 minute and 2 seconds", formatDuration(62));
        assertEquals("2 minutes", formatDuration(120));
        assertEquals("1 hour", formatDuration(3600));
        String res = formatDuration(3662);
        assertEquals("1 hour, 1 minute and 2 seconds", res);
        assertEquals("now", formatDuration(0));
        assertEquals("1 year, 1 day, 1 hour and 1 minute", formatDuration(31626060));

    }

    private static String formatDuration(int seconds) {
        if (seconds < 1) {
            return "now";
        }
        Map<String, Integer> resultMap = fillDurationMap(seconds);

        if (resultMap.size() > 2) {
            String lastKey = new ArrayList<>(resultMap.keySet()).get(resultMap.size() - 1);
            return resultMap.entrySet().stream()
                    .limit(resultMap.size() - 1)
                    .map(stringIntegerEntry -> String.valueOf(stringIntegerEntry.getValue())
                            .concat(" ")
                            .concat(stringIntegerEntry.getKey())
                            .concat(formatEnding(stringIntegerEntry.getValue())))
                    .collect(Collectors.joining(", "))
                    .concat(" and ")
                    .concat(String.valueOf(resultMap.get(lastKey)))
                    .concat(" ")
                    .concat(lastKey)
                    .concat(formatEnding(resultMap.get(lastKey)));
        }

        return resultMap.entrySet().stream()
                .map(stringIntegerEntry ->
                        String.valueOf(stringIntegerEntry.getValue())
                                .concat(" ")
                                .concat(stringIntegerEntry.getKey())
                                .concat(formatEnding(stringIntegerEntry.getValue())))
                .collect(Collectors.joining(" and "));
    }

    private static String formatEnding(int value) {
        return value > 1 ? "s" : "";
    }

    private static Map<String, Integer> fillDurationMap(int seconds) {
        Map<String, Integer> tmpMap = new LinkedHashMap<>();
        int minute = 60;
        int hour = minute * 60;
        int day = hour * 24;
        int year = day * 365;

        int tmp = seconds;

        tmpMap.put("year", tmp / year);
        tmp = tmp - tmpMap.getOrDefault("year", 0) * year;

        tmpMap.put("day", tmp / day);
        tmp = tmp - tmpMap.getOrDefault("day", 0) * day;

        tmpMap.put("hour", tmp / hour);
        tmp = tmp - tmpMap.getOrDefault("hour", 0) * hour;

        tmpMap.put("minute", tmp / minute);
        tmp = tmp - tmpMap.getOrDefault("minute", 0) * minute;

        tmpMap.put("second", tmp);
        return tmpMap.entrySet().stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 0)
                .collect(LinkedHashMap::new,
                        (map, item) -> map.put(item.getKey(), item.getValue()),
                        Map::putAll);
    }
}
