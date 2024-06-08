package MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{
    private static int last_id = 1;
    private int id;
    public PlainOld(){
        this.id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld object: id = " + this.id);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Anna", "Bob", " Chuck", "Dave"));
        list.forEach(System.out::println);

        calculator(Integer::sum, 4, 25);
        calculator(Double::sum, 5.2, 6.3);

        Supplier<PlainOld> reference1 = PlainOld::new;

        PlainOld newPojo = reference1.get();

        System.out.println("------------------");
        System.out.println("Getting Array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        calculator((s1, s2) -> s1.concat(s2), "Hello", "World");
        calculator(String::concat, "Hello", "World");

        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello"));

        String result = "Hello".transform(u1);
        System.out.println(result);

        // We are using the result value to transform to the method reference inside the parenthesis
        result = result.transform(String::toLowerCase);
        System.out.println(result);

        Function<String, Boolean> f1 = String::isEmpty;
        boolean resultBoolean = result.transform(f1);
        System.out.println(resultBoolean);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of the operation: " + result);
    }
    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
