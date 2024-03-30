import java.util.stream.LongStream;
public class Functional5 {
    public static void main(String[] a){
        long time=System.currentTimeMillis();
        System.out.println(LongStream.range(0,10000000).parallel().sum());
        System.out.println(System.currentTimeMillis()-time);
    }
}
