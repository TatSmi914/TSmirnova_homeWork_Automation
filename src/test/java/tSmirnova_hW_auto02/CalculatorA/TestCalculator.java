package tSmirnova_hW_auto02.CalculatorA;

        import org.testng.Assert;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

public class TestCalculator {

    private CalculatorAutomation calculator;

    @BeforeClass
    public void calc() {
        calculator = new CalculatorAutomation();
    }

    @Test
    public void getSumTestA() {
        double expectedResult = 7;
        double actualResult = calculator.getSumTest(4, 3);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getSubscriptionTestA() {
        double expectedResult = 1;
        double actualResult = calculator.getSubscriptionTest(4, 3);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getMultiplicationTestA() {
        double expectedResult = 12;
        double actualResult = calculator.getMultiplicationTest(4, 3);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getDivisionTestA() {
        double expectedResult = 5;
        double actualResult = calculator.getDivisionTest(10, 2);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getDegreeTestA() {
        double expectedResult = 16;
        double actualResult = calculator.getDegreeTest(4, 2);
        Assert.assertEquals(expectedResult, actualResult);
    }
}