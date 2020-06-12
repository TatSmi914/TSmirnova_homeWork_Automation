package tSmirnova_hW_auto02.CalculatorA;

public class CalculatorAutomation {

    public CalculatorAutomation() {

    }

    public double getSumTest(double a, double b) {
        double result = a + b;
        System.out.println("getSum : " + result);
        return result;
    }

    public double getSubscriptionTest(double a, double b) {
        double result = a - b;
        System.out.println("getSubscription : " + result);
        return result;
    }

    public double getMultiplicationTest(double a, double b) {
        double result = a * b;
        System.out.println("getMultiplication : " + result);
        return result;
    }

    public double getDivisionTest(double a, double b) {
        double result = a / b;
        System.out.println("getDivision : " + result);
        return result;
    }

    public double getDegreeTest(double a, double b) {
        double result = Math.pow(a, b);
        System.out.println("getDegree : " + result);
        return result;
    }
}