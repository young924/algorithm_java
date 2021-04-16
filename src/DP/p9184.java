import java.util.Scanner;

// 신나는 함수 실행

public class p9184 {
    public static int a;
    public static int b;
    public static int c;
    public static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        while (!(a == -1 && b == -1 && c == -1)) {

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
        }
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
