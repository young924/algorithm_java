import java.util.Scanner;

// 로봇 청소기

public class p14503 {
    public static int N, M, r, c, d;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};	// 0, 1, 2, 3일 때 왼  // 도는 건 역
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();	// 0 북, 1 동, 2 남, 3 서

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        search(r, c);
    }

    public static void search(int x, int y) {
        /*
         * 1) d = 0
         * 왼쪽으로 회전 d -= 1
         *
         *
         */
    }
}
