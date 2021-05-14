import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 01타일

public class p1904 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        if (N == 1) dp = new int[2];
        else dp = new int[N];

        dp[0] = 1;
        dp[1] = 2;

        // System.out.println(dpRecursive(N-1));
        System.out.println(dpForLoop(N-1));
    }

    public static int dpRecursive(int n) {
        if (dp[n] == 0) dp[n] = (dpRecursive(n-1) + dpRecursive(n-2)) % 15746;
        return dp[n];
    }

    public static int dpForLoop(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;

        for (int i = 2; i < N; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }

        return dp[n];
    }
}
