import java.util.ArrayList;
import java.util.Scanner;

// 테트로미노

public class p14500 {
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static ArrayList<int[]> dotList = new ArrayList<>();

    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs1(i, j, 1, board[i][j]);
                dfs2(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void dfs1(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nX < N && nY >= 0 && nY < M && !visited[nX][nY]) {
                visited[nX][nY] = true;
                dfs1(nX, nY, depth+1, sum + board[nX][nY]);
                visited[nX][nY] = false;
            }
        }
    }

    public static void dfs2(int x, int y) {
        int max_sum = 0;

        // ㅜ
        if (y - 1 >= 0 && y + 1 < M && x + 1 < N) {
            max_sum = Math.max(max_sum, board[x][y] + board[x][y-1] + board[x][y+1] + board[x+1][y]);
        }

        // ㅏ
        if (x - 1 >= 0 && x + 1 < N && y + 1 < M) {
            max_sum = Math.max(max_sum, board[x][y] + board[x-1][y] + board[x+1][y] + board[x][y+1]);
        }

        // ㅗ
        if (y - 1 >= 0 && y + 1 < M && x - 1 >= 0) {
            max_sum = Math.max(max_sum, board[x][y] + board[x][y-1] + board[x][y+1] + board[x-1][y]);
        }

        // ㅓ
        if (x - 1 >= 0 && x + 1 < N && y - 1 >= 0) {
            max_sum = Math.max(max_sum, board[x][y] + board[x-1][y] + board[x+1][y] + board[x][y-1]);
        }

        max = Math.max(max, max_sum);
    }

    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
