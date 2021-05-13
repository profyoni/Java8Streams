package edu.touro.cs;
//https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
import java.util.Arrays;
import java.util.Comparator;
import java.util.List; // reference
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
class Anagram // UN-tested
{
    public static String canonicalFormRemoveDuplicate(String s)
    {
        return s.toUpperCase()
                .chars()
                .distinct()
                .sorted()
                .mapToObj(c->((char)c) + "")
                .collect(Collectors.joining());
    }

    public static List<List<String>> findAllAnagrams(List<String> wordList) {
        return wordList
                .stream()
                .collect(groupingBy(Main::canonicalFormRemoveDuplicate))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> entry.getValue().stream().sorted().collect(Collectors.toList()))
                .sorted(Comparator.comparing(l -> l.get(0)))
                .collect(Collectors.toList());
    }
}

public class Main {
    public static String canonicalFormRemoveDuplicate(String s)
    {
        return s.toUpperCase()
                .chars()
                .distinct()
                .sorted()
                .mapToObj(c->((char)c) + "")
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {

//        List<String> myList =
//                Arrays.asList("a1", "a2", "b1", "c2", "c1");
//
//        myList
//                .stream()
//                .filter( s -> s.startsWith("c"))
//                .map(s -> s.toUpperCase() ) // method reference
//                .sorted()
//                .forEach(System.out::println);
//
//
//        long count =
//        Arrays.asList("Abe", "Bob", "David", "Snufulufufus", "T", "Abe")
//                .stream()
//                .map(s -> s.length())
//                .count();
//        System.out.println(count);
//
//        long x =
//        LongStream.range(1, 4_000_000_000_000_000_000L)
//                .map(l -> myMethod(l))
//                .skip(10L)
//                .findFirst()
//                .getAsLong();
//
//        System.out.println(x);

//        IntStream
//                .range(1, 4)
//                .mapToDouble(i -> i+0.1)
//                .forEach(System.out::println);

//        Stream.of(1.0, 2.0, 3.0)
//                .mapToInt(Double::intValue)
//                .mapToObj(i -> "a" + i)
//                .forEach(System.out::println);

        if (1 == 2) // optimizing compiler
        {
            List<Object> list =
            Stream.of("d2", "a2", "b1", "b3", "c")
                    .filter(s -> {
                        // System.out.println("filter: " + s);
                        return s.length()>1;
                    })
                    .collect(Collectors.toList());
        }

        Arrays.stream(new int[] {})
                .map(n -> 2 * n + 1)
                .max()
                .ifPresent(System.out::println);  // 5.0

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a") || s.startsWith("A");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
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
