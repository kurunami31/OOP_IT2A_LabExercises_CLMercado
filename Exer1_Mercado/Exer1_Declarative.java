import java.util.Arrays;
import java.util.List;

public class Exer1_Declarative {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 6, 9, 12, 15, 3, 18, 21, 24);

        numbers.stream()
                .distinct()
                .filter(n -> n % 3 == 0)
                .map(n -> n * n * n)
                .sorted()
                .forEach(System.out::println);
    }
}