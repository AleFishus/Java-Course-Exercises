package LambdaExpressions;

import java.util.ArrayList;
import java.util.List;

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
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2){
        T result = function.operate(value1, value2);
        System.out.println("Result of the operation: " + result);
        return result;
    }
}
