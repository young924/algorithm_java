import java.util.Scanner;

public class p1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;
        int number = 0;

        while (count != N) {
            number++;
            if (Integer.toString(number).contains("666")) {
                count++;
            }
        }

        System.out.println(number);
    }
}
