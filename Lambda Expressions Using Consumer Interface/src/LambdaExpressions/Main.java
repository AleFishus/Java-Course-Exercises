package LambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("--------");
        list.forEach( myString -> System.out.println(myString) );

        System.out.println("--------");
        list.forEach( myString -> {
            switch (myString){
                case "alpha" : System.out.println("a");
                break;
                case "bravo" : System.out.println("b");
                break;
                case "charlie" : System.out.println("c");
                break;
                case "delta" : System.out.println("d");
                break;
            }
        });

        System.out.println("--------");
        String prefix = "letter";
        list.forEach( myString -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + first + " means " + myString);
        });

        System.out.println("--------");
        // Lambda Expression is used to define the abstract method
        int result = calculator(((a, b) -> a + b), 5, 7);
        var result2 = calculator(((a, b) -> a / b), 5.5, 2.4);
        var result3 = calculator(((a, b) -> a.toUpperCase() + " " + b.toUpperCase()), "alejandro", "de jesus");

        System.out.println("--------");
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1560, -89.2495},
                new double[]{35.1556, -90.0659});
        coords.forEach( s -> System.out.println(Arrays.toString(s)) );

        // Lambda Expression assigned to a local variable and using it in a function
        System.out.println("--------");
        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f long:%.3f]\n", lat, lng);
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("--------");
        coords.forEach( s -> processPoint(s[0], s[1], p1));
        System.out.println("--------");
        coords.forEach( s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f long:%.3f]\n", lat, lng)));

        System.out.println("--------");
        list.removeIf( s -> s.equalsIgnoreCase("bravo"));
        list.forEach( s -> System.out.println(s));

        System.out.println("--------");
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach( s -> System.out.println(s));
        list.removeIf( s -> s.startsWith("ea"));
        list.forEach( s -> System.out.println(s));
        //Predicate<String> pred = (a, b) -> (a == b) ? true : false;

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of the operation: " + result);
        return result;
    }
    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }
}
