import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CheckTextTest {
    private final Map<String, Boolean> parseExpr = new HashMap<String, Boolean>();

    @BeforeClass
    private void setUp() {
        parseExpr.put("1+1", true);
        parseExpr.put("1+10", true);
        parseExpr.put("1*1", true);
        parseExpr.put("1-1", true);
        parseExpr.put("1**1", false);
        parseExpr.put("X+X", true);
        parseExpr.put("X+1", false);
//        parseExpr.put("XX+1", true);

    }
    @AfterTest
    void tearDown() {
        parseExpr.clear();
    }

    @Test
    public void isRightExpressionTest() {
        for (Map.Entry<String, Boolean > entry : parseExpr.entrySet()) {
            String exp = entry.getKey();
            boolean actual=CheckText.isRightExpression(exp);
            boolean expected = entry.getValue();
            assertEquals(actual, expected);
        }

    }

    @Test
    public void isRimExpression() {

    }

}
