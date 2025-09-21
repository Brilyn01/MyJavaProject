import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        String sentence;
        System.out.println("Enter Your Sentence .");
        Scanner scanner = new Scanner(System.in);
         sentence = scanner.nextLine();


         String [] words = sentence.split("\\s+");

        StringJoiner result = new StringJoiner( " ");
        for (String word : words){
            if (!word.isEmpty()) {
                String Capitalizedwirds =
                        Character.toUpperCase(word.charAt(0))
                                + word.substring(1).toLowerCase();
                result.add(Capitalizedwirds);
            }}

        System.out.println(result.toString()); }

        }


