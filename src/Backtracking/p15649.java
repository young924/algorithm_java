import java.util.Scanner;

// N과 M (1)

public class p15649 {
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);
    }

    public static void dfs(int n, int m, int depth) {
        if (depth == m) {
            printArr();
        } else {
            for (int i = 0; i < n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(n, m, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void printArr() {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
