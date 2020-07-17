import java.util.*;

public class AppStart {
    public static void main(String[] args) {
        System.out.println("Enter expression: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        if (CheckText.isRightExpression(text)) {
            List<Lexems> lexems = Lexems.textAnalize(text);
            LexemeBuffer bufferLexem = new LexemeBuffer(lexems);
            int answer=Calculator.calculate(bufferLexem);
                if (CheckText.isRimExpression(text)){
                    System.out.println("Answer=: "+ConvertNumber.convertArabicToRim(answer));
                }
                else {
                    System.out.println("Answer=: "+answer);
                }

        } else {
            throw new RuntimeException("Wrong expression format");
        }

    }
}
