import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.stream.Collectors;

class Course {

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                '}';
    }

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    private String name;
    private String category;

    private int reviewScore;

    private int noOfStudents;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }



    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}

public class FP04CustomClass {

    public static void main(String...a){
        List<Course> courses =
        List.of(new Course("String","Framework", 98, 20000),
                new Course("Spring Boot","Framework", 95, 18000),
                new Course("API","Framework", 97, 22000),
                new Course("Microservice","Micrservices", 96, 25000),
                new Course("FullStack","FullStack", 91, 14000),
                new Course("AWS","Cloud", 92, 21000),
                new Course("Azure","Cloud", 99, 21000),
                new Course("Docker","Cloud", 92, 20000),
                new Course("Kubernetes","Cloud", 91, 20000));

        //allMatch
        //noneMatch
        //anyMatch

        Predicate<Course> reviewScoreGreateThan95Predicate = c->c.getReviewScore()>95;
        Predicate<Course> reviewScoreGreateThan90Predicate = c-> c.getReviewScore()>90;

        Predicate<Course> reviewScoreLessThan90Predicate = c-> c.getReviewScore()<90;

        System.out.println(courses.stream()
                .allMatch(course->course.getReviewScore()>95));

        System.out.println(courses.stream()
                .noneMatch(course->course.getReviewScore()>95));

        System.out.println(courses.stream()
                .noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream()
                .anyMatch(reviewScoreLessThan90Predicate));

        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing)
                .collect(Collectors.toList()));
        //[Course{name='Microservice', category='Micrservices', reviewScore=96}, Course{name='API', category='Framework', reviewScore=97}, Course{name='AWS', category='Cloud', reviewScore=92}, Course{name='Azure', category='Cloud', reviewScore=99}, Course{name='String', category='Framework', reviewScore=98}, Course{name='Docker', category='Cloud', reviewScore=92}, Course{name='Kubernetes', category='Cloud', reviewScore=91}, Course{name='Spring Boot', category='Framework', reviewScore=95}, Course{name='FullStack', category='FullStack', reviewScore=91}]

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviewsIncreasing = Comparator.comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore)
                .reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviewsIncreasing)
                        .skip(3)
                .collect(Collectors.toList()));
        //[Course{name='AWS', category='Cloud', reviewScore=92}, Course{name='String', category='Framework', reviewScore=98}, Course{name='Docker', category='Cloud', reviewScore=92}, Course{name='Kubernetes', category='Cloud', reviewScore=91}, Course{name='Spring Boot', category='Framework', reviewScore=95}, Course{name='FullStack', category='FullStack', reviewScore=91}]

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviewsIncreasing)
                .skip(3)
                        .limit(5)
                .collect(Collectors.toList()));
        //[Course{name='AWS', category='Cloud', reviewScore=92}, Course{name='String', category='Framework', reviewScore=98}, Course{name='Docker', category='Cloud', reviewScore=92}, Course{name='Kubernetes', category='Cloud', reviewScore=91}, Course{name='Spring Boot', category='Framework', reviewScore=95}]

        System.out.println(courses.stream()
                .takeWhile(c->c.getReviewScore()>=95)
                .collect(Collectors.toList()));
        //[Course{name='String', category='Framework', reviewScore=98}, Course{name='Spring Boot', category='Framework', reviewScore=95}, Course{name='API', category='Framework', reviewScore=97}, Course{name='Microservice', category='Micrservices', reviewScore=96}]

        System.out.println(courses.stream()
                .dropWhile(c->c.getReviewScore()>=95)
                .collect(Collectors.toList()));
        //[Course{name='FullStack', category='FullStack', reviewScore=91}, Course{name='AWS', category='Cloud', reviewScore=92}, Course{name='Azure', category='Cloud', reviewScore=99}, Course{name='Docker', category='Cloud', reviewScore=92}, Course{name='Kubernetes', category='Cloud', reviewScore=91}]

        System.out.println(courses.stream()
                .max(comparingByNoOfStudentsAndNoOfReviewsIncreasing));
        //Optional[Course{name='FullStack', category='FullStack', reviewScore=91}

        System.out.println(courses.stream()
                .min(comparingByNoOfStudentsAndNoOfReviewsIncreasing));
        //Optional[Course{name='Microservice', category='Micrservices', reviewScore=96}]

        System.out.println(courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(comparingByNoOfStudentsAndNoOfReviewsIncreasing));
        //Optional.empty

        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReviewsIncreasing)
                .orElse(new Course("Kubernetes","Cloud", 91, 20000)));
        //Course{name='Kubernetes', category='Cloud', reviewScore=91}


        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .findFirst());
        //Optional.empty

        System.out.println(courses.stream()
                .filter(reviewScoreGreateThan95Predicate)
                .findFirst());
        //Optional[Course{name='String', category='Framework', reviewScore=98}]

        System.out.println(courses.stream()
                .filter(reviewScoreGreateThan95Predicate)
                .findAny());
        //Optional[Course{name='String', category='Framework', reviewScore=98}]

        System.out.println(courses.stream()
                .filter(reviewScoreGreateThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .sum());
        //88000

        System.out.println(courses.stream()
                .filter(reviewScoreGreateThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average());
        //OptionalDouble[22000.0]

        System.out.println(courses.stream()
                .filter(reviewScoreGreateThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .count());
        //4

        System.out.println(courses.stream()
                .filter(reviewScoreGreateThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .max());
        //OptionalInt[25000]

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));
        //{Cloud=[Course{name='AWS', category='Cloud', reviewScore=92},
        // Course{name='Azure', category='Cloud', reviewScore=99},
        // Course{name='Docker', category='Cloud', reviewScore=92},
        // Course{name='Kubernetes', category='Cloud', reviewScore=91}],
        // Micrservices=[Course{name='Microservice', category='Micrservices', reviewScore=96}],
        // FullStack=[Course{name='FullStack', category='FullStack', reviewScore=91}],
        // Framework=[Course{name='String', category='Framework', reviewScore=98},
        // Course{name='Spring Boot', category='Framework', reviewScore=95},
        // Course{name='API', category='Framework', reviewScore=97}]}

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        //{Cloud=4, Micrservices=1, FullStack=1, Framework=3}

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        //{Cloud=Optional[Course{name='Azure', category='Cloud', reviewScore=99}],
        // Micrservices=Optional[Course{name='Microservice', category='Micrservices', reviewScore=96}],
        // FullStack=Optional[Course{name='FullStack', category='FullStack', reviewScore=91}],
        // Framework=Optional[Course{name='String', category='Framework', reviewScore=98}]}

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory
                ,Collectors.mapping(Course::getName,Collectors.toList()))));
        //{Cloud=[AWS, Azure, Docker, Kubernetes], Micrservices=[Microservice], FullStack=[FullStack], Framework=[String, Spring Boot, API]}


        int cutOffReviewScore =95;

        Predicate<Course> reviewScoreGreateThan95Predicate2 = createPredicateWithCutOffReviewScore(95);

        Predicate<Course> reviewScoreGreateThan90Predicate2 = createPredicateWithCutOffReviewScore(90);






    }

    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutoffReviewScore){
        return c-> c.getReviewScore()>cutoffReviewScore;
    }
}
