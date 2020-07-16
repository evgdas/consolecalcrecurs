import java.util.ArrayList;
import java.util.List;

public class Lexems {
    public enum LexemType {NUMBER, PLUS, MINUS,MUL,DIV, EOF}

    LexemType type;
    String value;

    public Lexems(LexemType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Lexems(LexemType type, Character value) {
        this.type = type;
        this.value = value.toString();
    }

    @Override
    public String toString() {
        return "Lexem{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

    public static List<Lexems> textAnalize(String text) {
        ArrayList<Lexems> lexems = new ArrayList<>();
        int pos = 0;
        while (pos < text.length()) {
            char c = text.charAt(pos);
            switch (c) {
                case '+':
                    lexems.add(new Lexems(LexemType.PLUS, c));
                    pos++;
                    continue;
                case '*':
                    lexems.add(new Lexems(LexemType.MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexems.add(new Lexems(LexemType.DIV, c));
                    pos++;
                    continue;
                case '-':
                    lexems.add(new Lexems(LexemType.MINUS, c));
                    pos++;
                    continue;
                case 'I':
                    StringBuilder stringBuilderI=new StringBuilder();
                    do{
                        stringBuilderI.append(c);
                        pos++;
                        if (pos>=text.length()){break;}
                        c=text.charAt(pos);
                    }while (c=='I' ||c=='V'||c=='X');
                    int numberI=ConvertNumber.convertRomanToInt(stringBuilderI.toString());
                    lexems.add(new Lexems(LexemType.NUMBER, String.valueOf(numberI)));

                    continue;
                case 'V':
                    StringBuilder stringBuilderV=new StringBuilder();
                    do{
                        stringBuilderV.append(c);
                        pos++;
                        if (pos>=text.length()){break;}
                        c=text.charAt(pos);
                    }while (c=='I');
                    int numberV=ConvertNumber.convertRomanToInt(stringBuilderV.toString());
                    lexems.add(new Lexems(LexemType.NUMBER, String.valueOf(numberV)));

                    continue;
                case 'X':
                    lexems.add(new Lexems(LexemType.NUMBER, "10"));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= text.length()) {
                                break;
                            }
                            c = text.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexems.add(new Lexems(LexemType.NUMBER, sb.toString()));

                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("wrong number");

                        }
                        pos++;

                    }
            }
        }
        lexems.add(new Lexems(LexemType.EOF,""));
        return lexems;


    }
}

