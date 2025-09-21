import java.util.Scanner;

public class Secondprogram {
    public static void main(String[] args)
    {
        System.out.print("How many Numbers will be inputted? ");

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] numbers = new int[size];


        for (int i = 0; i < size; i++) {
            int holder=scanner.nextInt();
            numbers[i] = holder;
            int Double =i*2;
        }


        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                count++;
            }
        }


        int[] evens = new int[count];
        int index = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evens[index++] = num;
            }
        }


        int sum = 0;
        for (int num : evens) {
            int multiple = num * 2;
            sum += multiple;
        }

        System.out.println("The sum of the multiplied inputed even numbers is " + sum);
    }
}
