import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CheckTextTest {

    @DataProvider
    public Object[][] expr() {
        return new Object[][]{
                {"1+1", true},
                {"1-1", true},
                {"1*1", true},
                {"1\1", false},
                {"1++1", false}


        };
    }

    @DataProvider
    public Object[][] exprRim() {
        return new Object[][]{
                {"1+1", false},
                {"1-1", false},
                {"1*1",false},
                {"X+X", true},
                {"X+1", false}


        };
    }


    @Test(dataProvider = "expr")
    public void isRightExpressionTest(String expr, boolean expected) {
        boolean actual = CheckText.isRightExpression(expr);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "exprRim")
    public void isRimExpression(String exprRim, boolean expected) {
        boolean actual = CheckText.isRimExpression(exprRim);
        assertEquals(actual, expected);

    }

}
