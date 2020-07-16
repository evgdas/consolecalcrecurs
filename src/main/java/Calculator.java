public class Calculator {
    public static int calculate (LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexems lex = lexemes.next();
            switch (lex.type) {
                case PLUS:
                    value += factor(lexemes);
                    break;
                case MUL:
                    value *= factor(lexemes);
                    break;
                case DIV:
                    value /= factor(lexemes);
                    break;                case MINUS:
                    value -= factor(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }

    }

    public static int factor(LexemeBuffer lexemes) {
        Lexems lex = lexemes.next();
        switch (lex.type) {
            case NUMBER:
                return Integer.parseInt(lex.value);
            default:
                return 0;
        }


    }

}
