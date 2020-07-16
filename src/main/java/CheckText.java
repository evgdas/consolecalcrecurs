import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckText {
    private static Pattern patternRim = Pattern.compile("(I{1,3}|V|IV|VI|VII|VIII|IX|X)([+-\\\\*/])(I{1,3}|V|IV|VI|VII|VIII|IX|X)");
    private static Pattern patternDigit = Pattern.compile("([1-9]|10)([+-\\\\*/])([1-9]|10)");

    static boolean isRightExpression(String text) {
        Matcher matcherRim = patternRim.matcher(text);
        Matcher matcherDigit = patternDigit.matcher(text);

        return matcherDigit.matches() || matcherRim.matches();
    }

    static boolean isRimExpression(String text) {
        Matcher matcherRim = patternRim.matcher(text);
        return matcherRim.matches();
    }
}
