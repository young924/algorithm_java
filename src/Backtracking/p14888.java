import java.util.Scanner;

// 연산자 끼워넣기

public class p14888 {
    public static int N;
    public static int[] nums;
    public static int[] operators = new int[4];
    public static int max = -2000000000;
    public static int min = 2000000000;
    public static int[] results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        nums = new int[N];
        results = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i< 4; i++) {
            operators[i] = sc.nextInt();
        }

        results[0] = nums[0];

        dfs(1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            if (results[N-1] > max) max = results[N-1];
            if (results[N-1] < min) min = results[N-1];
        } else {
            for (int i = 0; i < 4; i++) {
                if (operators[i] > 0) {
                    if (i == 0) {
                        results[depth] = results[depth-1] + nums[depth];
                        operators[i]--;
                        dfs(depth+1);
                        operators[i]++;
                    } else if (i == 1) {
                        results[depth] = results[depth-1] - nums[depth];
                        operators[i]--;
                        dfs(depth+1);
                        operators[i]++;
                    } else if (i == 2) {
                        results[depth] = results[depth-1] * nums[depth];
                        operators[i]--;
                        dfs(depth+1);
                        operators[i]++;
                    } else {
                        results[depth] = results[depth-1] / nums[depth];
                        operators[i]--;
                        dfs(depth+1);
                        operators[i]++;
                    }
                }
            }
        }
    }
}
