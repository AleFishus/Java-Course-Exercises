package LambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

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

        // BiPredicate Lambda Expression Category
        BiPredicate<String, String> pred = (String a, String b) -> (a.equals(b)) ? true : false;
        System.out.println("--------");
        compare("Hola", "Adios", pred);

        // Function Lambda Expression Category
        System.out.println("--------");
        list.replaceAll( s -> s.charAt(0) + "-" + s.toUpperCase());
        list.forEach( s -> System.out.println(s));

        System.out.println("--------");
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
            + switch (i){
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";
                }
        );
        System.out.println(Arrays.toString(emptyStrings));

        // Supplier Lambda Expression Category
        System.out.println("--------");
        String[] names = {"Alejandro", "Yadira", "Oscar", "Yesenia", "Chris", "Ana"};
        String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of the operation: " + result);
        return result;
    }
    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }
    public static<T> void compare(T s1, T s2, BiPredicate<T, T> predicate){
        System.out.println(predicate.test(s1, s2));
    }
    public static String[] randomlySelectedValues(int count, String values[], Supplier<Integer> s){
        String selectedValues[] = new String[count];
        for(int i = 0 ; i < count ; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
