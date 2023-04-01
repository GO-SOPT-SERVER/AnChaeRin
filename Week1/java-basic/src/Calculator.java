public class Calculator {
    Character operator;

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int intResult = calculator.add(1, 10);
        double doubleResult = calculator.add(1, 10);

        System.out.println(intResult);
        System.out.println(doubleResult);
    }
}
