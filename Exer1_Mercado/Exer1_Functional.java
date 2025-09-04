import java.util.Arrays;

public class Exer1_Functional {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };

        Arrays.stream(numbers)
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}