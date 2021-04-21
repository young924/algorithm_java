import java.util.Scanner;

// 컨베이어 벨트 위의 로봇

public class p20055 {
    static int N, K;
    static int[] A;
    static boolean[] robot;
    static int numOfZero;
    static int stage;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        A = new int[2*N+1];
        robot = new boolean[N+1];
        numOfZero = 0;
        stage = 0;

        for (int i = 1; i <= 2*N; i++) {
            A[i] = sc.nextInt();
        }

        while (numOfZero < K) {
            stage++;

            // 1. 회전
            A[0] = A[2*N];

            for (int i = 2*N; i >= 1; i--) {
                A[i] = A[i-1];
            }

            for (int i = N; i > 1; i--) {
                robot[i] = robot[i-1];
            }

            robot[1] = false;
            robot[N] = false;

            // 2. 로봇 옮기기
            for (int i = N-1; i >= 1; i--) {
                if (!robot[i+1] && robot[i] && A[i+1] > 0) {
                    robot[i+1] = true;
                    robot[i] = false;
                    A[i+1]--;
                    if (A[i+1] == 0) numOfZero++;
                }
            }

            // 3. 로봇 올리기
            if (A[1] > 0) {
                robot[1] = true;
                A[1]--;
                if (A[1] == 0) numOfZero++;
            }

        }

        System.out.println(stage);
    }
}
