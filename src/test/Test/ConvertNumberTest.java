import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConvertNumberTest {
    @DataProvider
    public Object[][] exprRim() {
        return new Object[][]{
                {"I", "1"},
                {"II", "2"},
                {"III", "3"},
                {"IV", "4"},
                {"V", "5"},
                {"VI", "6"},
                {"VII", "7"},
                {"VIII", "8"},
                {"IX", "9"},
                {"X", "10"}

        };
    }

    @DataProvider
    public Object[][] exprArabic() {
        return new Object[][]{
                {"1", "I"},
                {"2", "II"},
                {"3", "III"},
                {"4", "IV"},
                {"5", "V"},
                {"6", "VI"},
                {"7", "VII"},
                {"8", "VIII"},
                {"9", "IX"},
                {"10", "X"}

        };
    }
    @Test(dataProvider = "exprArabic")
    public void isConvertArabicToRimConvert (String actualArabic, String expectedRim){
        String actualRim=ConvertNumber.convertArabicToRim(Integer.parseInt(actualArabic));
        Assert.assertEquals(actualRim,expectedRim);
    }
    @Test(dataProvider = "exprRim")
    public void isConvertRimToArabic(String actualRim, String expectedArabic){
        String actualArabic=String.valueOf(ConvertNumber.convertRimToArabic(actualRim));
        Assert.assertEquals(actualArabic,expectedArabic);
    }
}
