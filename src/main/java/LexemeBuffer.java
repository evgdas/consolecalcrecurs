import java.util.List;

public class LexemeBuffer {
    int pos;
    public List<Lexems> lexems;

    public LexemeBuffer(List<Lexems> lexems) {
        this.lexems = lexems;
    }
    public Lexems next(){
        return lexems.get(pos++);

    }
    public void back()
    { pos--;}
    public int getPos(){
        return pos;
    }
}
