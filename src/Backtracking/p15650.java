import java.util.Scanner;

public class p15650 {
    public static int[] arr;
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(1, 0);
    }

    public static void dfs (int curr, int depth) {
        if (depth == M) {
            printArr();
        } else {
            for (int i = curr; i <= N; i++) {
                arr[depth] = i;
                dfs(i+1, depth + 1);
            }
        }
    }

    public static void printArr() {
        for (int i = 0; i < M; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
