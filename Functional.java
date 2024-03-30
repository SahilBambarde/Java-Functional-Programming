import java.util.List;
public class Functional {
    public static void main(String...a){
        //print all the numbers in the list
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");


        //printAllTheNumbersInTheListFuntional(List.of(12,9,13,4,6,2,4,12,15));
        //printEvenNumbersInListStructured(numbers);
        //printOddNumbersInList(numbers);
        //printAllCourses(courses);
        //printSquareEvenNumber(numbers);
        //printCudeOddNumber(numbers);
        //printLengthAllCourses(courses);
        int sum = addList(numbers);
        System.out.println(sum);

    }

    private static void print(int number){
        System.out.println(number);
    }

    private static void printAllTheNumbersInTheListFuntional(List<Integer> numbers){

//        numbers.stream()
//                .forEach(Structured::print);

//        numbers.stream()
//                .forEach(System.out::println);

        //How to loop the numbers?
//        for(int number: numbers){
//            System.out.println(number);
//        }
    }

    private static boolean isEven(int number){
        return number%2==0;
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers){
//        for(int number: numbers){
//            if(number%2==0){
//                System.out.println(number);
//            }
//        }
//        numbers.stream()
//                .filter(Structured::isEven)
//                .forEach(System.out::println);

//        numbers.stream()
//                .filter(number -> number%2==0) lambda expression
//                .forEach(System.out::println);


    }

    private static void printOddNumbersInList(List<Integer> numbers){
        numbers.stream()
                .filter(n->n%2!=0)
                .forEach(System.out::println);
    }

    private static void printLengthAllCourses(List<String> courses){
        courses.stream()
                .map(c->c + " " +c.length())
                .forEach(System.out::println);
    }

    private static void printSquareEvenNumber(List<Integer> numbers){
        numbers.stream()
                .filter(n->n%2==0)
                .map(n-> n*n)
                .forEach(System.out::println);
    }

    private static void printCudeOddNumber(List<Integer> numbers){
        numbers.stream()
                .filter(n->n%2!=0)
                .map(n->n*n*n)
                .forEach(System.out::println);
    }

    private static int sum(int a,int b){
        System.out.println(a +" "+ b);
//        0 12
//        12 9
//        21 13
//        34 4
//        38 6
//        44 2
//        46 4
//        50 12
//        62 15
//        77

        return a+b;
    }

    private static int addList(List<Integer> numbers){
//        int sum =0;
//        for(int n:numbers){
//            sum+=n;
//        }
//        return sum;

        return numbers.stream()
                //.reduce(0, Functional::sum);
                //.reduce(0,(x,y)->x+y);
                .reduce(0,Integer::sum);

    }
}
