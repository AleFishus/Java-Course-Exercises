package LambaExpressions;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        //CHALLENGE 1 "CONSUMER"
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

        printTheParts.accept("This is the sentence we will use to test");
        System.out.println("---------------------");
        printThePart.accept("This is the sentence we will use to test");

        //CHALLENGE 2 "FUNCTION"
        System.out.println("---------------------");
        System.out.println( everySecondChar("Hello how are you?" ));
        UnaryOperator<String> printEverySecondChar = (sentence) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0 ; i < sentence.length() ; i++){
                if (i % 2 == 1){
                    returnVal.append(sentence.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println( printEverySecondChar.apply("Hello how are you?" ));

        //CHALLENGE 3 "TEST CHALLENGE2"
        System.out.println("---------------------");
        System.out.println( everySecondChar("1234567890" ));
        System.out.println( printEverySecondChar.apply("1234567890" ));
    }



    // CHALLENGE 2 "FUNCTION"
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0 ; i < source.length() ; i++){
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }
}
