import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest {
    @DataProvider
    public Object[][] exprCalculate() {
        return new Object[][]{
                {"1+1", 2},
                {"1-1", 0},
                {"1*1",1},
                {"10+10", 20},
                {"10+1", 11},
                {"1-10", -9}


        };
    }

    @Test (dataProvider = "exprCalculate")
    public void calculateTest(String expr, int expected){
        List<Lexems> lexems = Lexems.textAnalize(expr);
        LexemeBuffer bufferLexem = new LexemeBuffer(lexems);
        int answer=Calculator.calculate(bufferLexem);
        Assert.assertEquals(answer,expected);
    }

}
