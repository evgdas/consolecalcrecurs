import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CheckTextTest {

    @DataProvider
    public Object[][] parseExpr() {
        return new Object[][]{
                {"1+1", true},
                {"1-1", true},
                {"1*1", true},
                {"1\1", false},
                {"1++1", false}


        };
    }


    @Test(dataProvider = "parseExpr")
    public void isRightExpressionTest(String expr, boolean expected) {
        boolean actual = CheckText.isRightExpression(expr);
        assertEquals(actual, expected);
    }

    @Test
    public void isRimExpression() {

    }

}
