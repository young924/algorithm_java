import java.util.Scanner;

// 컨베이어 벨트 위의 로봇

public class p20055 {
    static int N, K;
    static int[] A;
    static boolean[] robot;
    static int numOfZero;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        A = new int[2*N+1];
        robot = new boolean[N+1];
        numOfZero = 0;

        for (int i = 1; i <= 2*N; i++) {
            A[i] = sc.nextInt();
        }

        while (numOfZero < K) {
            // 1. 회전

        }
    }
}
