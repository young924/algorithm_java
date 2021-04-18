import java.util.Scanner;

// 로봇 청소기

public class p14503 {
    public static int N, M, r, c, d;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};	// 0, 1, 2, 3일 때 왼쪽
    public static int[][] board;
    public static boolean[][] cleaned;
    public static int numOfBlock = 1;
    public static int x;
    public static int y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();	// 0 북, 1 동, 2 남, 3 서

        board = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        cleaned[r][c] = true;

        x = r;
        y = c;

        search();

        System.out.println(numOfBlock);
    }

    public static void search() {

        while (true) {
            boolean canClean = false;

            for (int i = d; i > d-4; i--) {
                int idx = (i + 4) % 4;
                int nX = x + dx[idx];
                int nY = y + dy[idx];

                if (board[nX][nY] == 0 && !cleaned[nX][nY]) {
                    switch (idx) {
                        case 0 -> d = 3;
                        case 1 -> d = 0;
                        case 2 -> d = 1;
                        case 3 -> d = 2;
                    }
                    x = nX;
                    y = nY;
                    cleaned[x][y] = true;
                    numOfBlock++;
                    canClean = true;
                    break;
                }
            }

            if (!canClean) {
                int backIdx = (d + 3) % 4;
                int nX = x + dx[backIdx];
                int nY = y + dy[backIdx];

                if (board[nX][nY] == 0) {
                    x = nX;
                    y = nY;
                } else {
                    return;
                }
            }
        }

    }

    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cleaned[i][j]) {
                    System.out.print(2+" ");
                } else {
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}