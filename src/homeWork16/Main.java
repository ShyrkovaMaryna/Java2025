package homeWork16;

import java.util.function.Function;
import  java.util.function.Supplier;
import static homeWork16.RandomNumberGenerator.generateRandomNumber;


public class Main {
    public static void main(String[] args) {
        MathOperation addition;
        addition = Integer::sum;
        System.out.println("Addition 15 and 9 = " + addition.operate(15,9));

        StringManipulator toUpperCase = String::toUpperCase;
        System.out.println("hello, world! ---- " + toUpperCase.manipulate("hello, world!"));

        Function<String, Integer> countUppercaseFunction = StringListProcessor::countUppercase;
        System.out.println("Number of capital letters in (Random Phrase) = " +
                countUppercaseFunction.apply("Random Phrase"));

        Supplier<Integer> randomSupplier = () -> generateRandomNumber(1, 100);
        System.out.println("Random number: " + randomSupplier.get());
    }

}
