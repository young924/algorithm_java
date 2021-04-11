import java.util.Scanner;

public class p9663 {
    public static int[] board;
    public static int N;
    public static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N];

        result = 0;

        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            result++;
        } else {
            for (int i = 0; i < N; i++) {
                if (checkBoard(depth, i)) {
                    board[depth] = i;
                    dfs(depth+1);
                }
            }
        }
    }

    public static boolean checkBoard(int depth, int x) {
        for (int i = 0; i < depth; i++) {
            if (board[i] == x) return false;
            if (Math.abs(depth - i) == Math.abs(x - board[i])) return false;
        }

        return true;
    }
}
