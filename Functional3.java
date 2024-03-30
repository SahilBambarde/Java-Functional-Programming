import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.function.BiPredicate;
import java.util.function.BiFunction;
import java.util.function.BiConsumer;

public class Functional3 {

    public static void main(String...a){
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        Predicate<Integer> isEvenPredicte =x-> x%2==0;
        Predicate<Integer> isEvenPredicte2 =new Predicate<Integer>(){
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };
        Function<Integer,Integer> squareFunction = x->x*x;
        Function<Integer,Integer> squareFunction2 = new Function<Integer,Integer>(){

            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };

        Consumer<Integer> sysoutConsumer = System.out::println;
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>()
        {

            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                .filter(isEvenPredicte2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2);

        BinaryOperator<Integer> sumBinaryOpetator = new BinaryOperator<Integer>(){
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        };

        //No input Return somethings
        Supplier<Integer> randomIntegerSupplier = ()-> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        //System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3*x;

        //System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer,String> biPredicate = (number,str) -> {
        return number<10 && str.length()>5;
        };
        //System.out.println(biPredicate.test(5,"in28mintutes"));

        BiFunction<Integer,String,String> biFunction =(number,str) ->{
            return number+ " " +str;
        };
        //System.out.println(biFunction.apply(15,"in28minutes"));

        BiConsumer<Integer, String> biConsumer = (s1,s2) ->{
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept(125,"in28min");

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");


        courses.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(Functional3::print);

        Supplier<String> supplier = String::new;



    }
    private static void print(String str){
        System.out.println(str);
    }
}
