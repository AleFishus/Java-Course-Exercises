package LambaExpressions;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printThePart = (sentence) -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach( word -> System.out.println(word));
        };

        printTheParts.accept("This is the sentence we will use to test the anonymous class");
        System.out.println("---------------------");
        printThePart.accept("This is the sentence we will use to test the lambda expression");


    }
}
