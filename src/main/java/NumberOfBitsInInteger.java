/**
 * Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.
 *
 * Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
 */
public class NumberOfBitsInInteger {


    private static int countBits(int number){
        return Integer.toBinaryString(number).chars()
                .map(value -> {
                    if (value == 48)
                        return 0;
                    else return 1;
                }).sum();
    }

}
