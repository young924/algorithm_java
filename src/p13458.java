import java.util.Scanner;

// 시험 감독

public class p13458 {
    public static int N;
    public static int[] A;
    public static int B;
    public static int C;
    public static long sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        B = sc.nextInt();
        C = sc.nextInt();

        sum = N;

        for (int i = 0; i < N; i++) {
            A[i] -= B;
            A[i] = Math.max((int) Math.ceil((double)A[i] / C), 0);
            sum += A[i];
        }

        System.out.println(sum);
    }
}