import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
 * Examples
 * toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"
 * <p>
 * toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
 */
public class ConvertStringToCamelCase {

    public static void main(String[] args) {
        System.out.println("input the_Stealth_Warrior" + "expected is theStealthWarrior and actual is " + toCamelCase("the_Stealth_Warrior"));
        System.out.println("input the-Stealth-Warrior" + "expected is theStealthWarrior and actual is " + toCamelCase("the-Stealth-Warrior"));
        String input = "the_Stealth_Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", toCamelCase(input));

        input = "the-Stealth-Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", toCamelCase(input));
        System.out.println("You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields"+" actual is "+toCamelCase("You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields"));
    }

    private static String toCamelCase(String s) {
        String reg = "[-_ ]";
        return Arrays.stream(s.split(reg)).findFirst().orElse("")
                .concat(Stream.of(s.split(reg))
                        .skip(1)
                        .map(string -> string.substring(0, 1).toUpperCase().concat(string.substring(1)))
                        .collect(Collectors.joining("")));
    }
}
