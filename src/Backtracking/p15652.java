import java.util.Scanner;

// N과 M (4)

public class p15652 {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(1, 0);

        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            printArr();
        } else {
            for (int i = at; i <= N; i++) {
                arr[depth] = i;
                dfs(i, depth + 1);
            }
        }
    }

    public static void printArr() {
        for (int i = 0; i < M; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }
}
