import java.util.List;
import java.util.stream.Collectors;

public class Functional2 {
    public static void main(String...a){
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<Integer> squredNumbers=squredNumbers(numbers);
        //System.out.println(doubleNumbers);
        List<Integer> evenNumbersOnly = numbers.stream()
                .filter(x->x%2==0)
                .collect(Collectors.toList());
        System.out.println(evenNumbersOnly);
    }

    private static List<Integer> squredNumbers(List<Integer> numbers){
        return numbers.stream()
                .map(x-> x*x)
                .collect(Collectors.toList());
    }
}
