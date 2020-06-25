package ch.juventus.lambda;

import java.util.Date;
import java.util.function.Function;

public class LambdaExamples {

    public static void main(String[] args) {
        exerciseOne();
        exerciseTwo();
    }

    private static void exerciseOne() {
        Function<Date, String> dateStringFunction = date -> "Jetzt ist " + date;
        String now = dateStringFunction.apply(new Date());
        System.out.println(now);
    }

    private static void exerciseTwo() {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        System.out.println(executeMathOperation(2, 2, addition));
        System.out.println(executeMathOperation(2, 2, subtraction));
        System.out.println(executeMathOperation(2, 2, multiplication));
        System.out.println(executeMathOperation(2, 2, division));
    }

    private static int executeMathOperation(int a, int b, MathOperation mathOperation) {
        return mathOperation.operate(a, b);
    }

}
