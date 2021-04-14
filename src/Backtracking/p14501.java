import java.util.ArrayList;
import java.util.Scanner;

// 퇴사 

public class p14501 {
    public static int N;
    public static int[] T;
    public static int[] P;
    public static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(max);
    }

    public static void dfs(int depth, int result) {
        if (depth == N) {
            max = Math.max(max, result);
            return;
        }

        if (depth > N) {
            return;
        }

        dfs(depth + T[depth], result + P[depth]);
        dfs(depth+1, result);

    }
}