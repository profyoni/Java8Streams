package edu.touro.cs;
//https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
import java.util.Arrays;
import java.util.List; // reference
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter( s -> s.startsWith("c"))
                .map(s -> s.toUpperCase() ) // method reference
                .sorted()
                .forEach(System.out::println);


        long count =
        Arrays.asList("Abe", "Bob", "David", "Snufulufufus", "T", "Abe")
                .stream()
                .map(s -> s.length())
                .count();
        System.out.println(count);

        long x =
        LongStream.range(1, 4_000_000_000_000_000_000L)
                .map(l -> myMethod(l))
                .skip(10L)
                .findFirst()
                .getAsLong();

        System.out.println(x);
//
//    }
//
//    static public void whatever(Object o)
//    {
//        System.out.println(o);
//        // store in db
//    }
    }

    private static long myMethod(long l) {
        return l+1;
    }
}
