import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Collections.nCopies;

public class ConvertNumber {

    private static int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                return -1;
        }
    }

    public static int convertRimToArabic(String romanNumeral) {
        int result = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            if (letterToNumber(romanNumeral.charAt(i)) == -1) {
                throw new NumberFormatException("Invalid format");
            }
            if (i==0) {result += letterToNumber(romanNumeral.charAt(i));}
            else {
                if ((letterToNumber(romanNumeral.charAt(i))) <= letterToNumber(romanNumeral.charAt(i - 1))) {
                    result += letterToNumber(romanNumeral.charAt(i));
                } else {
                    result += letterToNumber(romanNumeral.charAt(i)) - 2 * letterToNumber(romanNumeral.charAt(i - 1));

                }
            }


        }
        return result;
    }


    public static String convertArabicToRim(int number) {
        return join("", nCopies(number, "I"))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");

    }
}
