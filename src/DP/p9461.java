import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파도반 수열

public class p9461 {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 0; i < T; i++) {
            System.out.println(doDP(Integer.parseInt(bf.readLine())));
        }
    }

    public static long doDP(int n) {
        if (n == 1 || n == 2 || n == 3) return 1;

        if (dp[n] != 0) return dp[n];

        return dp[n] = doDP(n-2) + doDP(n-3);
    }
}
