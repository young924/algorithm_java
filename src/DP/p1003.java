import java.util.Arrays;
import java.util.Scanner;

// 피보나치 함수

public class p1003 {
    public static int T;
    public static int[] fib0 = new int[50];
    public static int[] fib1 = new int[50];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        Arrays.fill(fib0, -1);
        Arrays.fill(fib1, -1);

        fib0[0] = 1;
        fib0[1] = 0;
        fib1[0] = 0;
        fib1[1] = 1;

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            fibonacci0(N);
            fibonacci1(N);
            sb.append(fib0[N]).append(" ").append(fib1[N]).append("\n");
        }

        System.out.println(sb);
    }

    public static int fibonacci0(int n) {
        if (fib0[n] == -1) {
            fib0[n] = fibonacci0(n-1) + fibonacci0(n-2);
        }
        return fib0[n];
    }

    public static int fibonacci1(int n) {
        if (fib1[n] == -1) {
            fib1[n] = fibonacci1(n-1) + fibonacci1(n-2);
        }
        return fib1[n];
    }
}
