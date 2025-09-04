import java.util.Arrays;
import java.util.List;

public class Exer1_Imperative {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                int squared = number * number;
                System.out.println(squared);
            }
        }
    }
}
