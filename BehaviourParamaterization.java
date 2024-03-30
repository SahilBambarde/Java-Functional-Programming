import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Function;

public class BehaviourParamaterization {
    public static void main(String...a){
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        Predicate<Integer> evenPredicate = x->x%2==0;
        Predicate<Integer> oddPredicate = x->x%2!=0;


//        numbers.stream()
//                .filter(x->x%2==0)
//                .forEach(System.out::println);
//        numbers.stream()
//                .filter(x->x%2!=0)
//                .forEach(System.out::println);

        Function<Integer,Integer> mappingFunction = x->x*x;

        List<Integer> squredNumbers = numbers.stream()
                .map(x->x*x)
                        .collect(Collectors.toList());

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, mappingFunction);

        List<Integer> cubeNumbers = mapAndCreateNewList(numbers, x->x*x*x);

        List<Integer> doubleNumbers = mapAndCreateNewList(numbers,x->x+x);

        System.out.println(doubleNumbers);

        //filterAndPrint(numbers,oddPredicate);
        filterAndPrint(numbers,x->x%3==0);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer,Integer> mappingFunction){
        return numbers.stream().map(mappingFunction).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate){
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
