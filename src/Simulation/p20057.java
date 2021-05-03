import java.util.Scanner;

// 마법사 상어와 토네이도

public class p20057 {
    public static int N;
    public static int[][] board;
    public static int dir;
    public static int r, c;
    public static int outSum;

    public static int[][] wX = {
            { -1, 1, -2, 2, -1, 1, -1, 1, 0 }, // Left
            { -1, -1, 0, 0, 0, 0, 1, 1, 2 }, // Down
            { -1, 1, -2, 2, -1, 1, -1, 1, 0 }, // Right
            { 1, 1, 0, 0, 0, 0, -1, -1, -2 }, // Up
    };
    public static int[][] wY = {
            { 1, 1, 0, 0, 0, 0, -1, -1, -2 }, // Left
            { 1, -1, 2, -2, 1, -1, 1, -1, 0 }, // Down
            { -1, -1, 0, 0, 0, 0, 1, 1, 2 }, // Right
            { 1, -1, 2, -2, 1, -1, 1, -1, 0 }, // Up
    };
    public static int[] percent = { 1, 1, 2, 2, 7, 7, 10, 10, 5 };

    public static int[] dX = { 0, 1, 0, -1 };
    public static int[] dY = { -1, 0, 1, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];

        r = N/2;
        c = N/2;
        dir = 0;
        outSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        simulation();
        System.out.println(outSum);
    }

    public static void simulation() {
        for (int i = 1; i < N; i++) {
            move(i);
            dir = (dir + 1) % 4;
            move(i);
            dir = (dir + 1) % 4;
        }
        move(N-1);
    }

    public static void move(int distance) {
        for (int i = 1; i <= distance; i++) {
            // spread

            int total = board[r][c];
            board[r][c] = 0;

            r += dX[dir];
            c += dY[dir];       // y가 현재 좌표
            board[r][c] += total;

            int remainder = board[r][c];

            for (int j = 0; j < 9; j++) {
                int nX = r + wX[dir][j];
                int nY = c + wY[dir][j];

                if (nX >= 0 && nX < N && nY >= 0 && nY < N) {
                    int amt = (int) Math.floor(board[r][c] * percent[j] * 0.01);
                    board[nX][nY] += amt;
                }
            }

            int aX = r + dX[dir];
            int aY = c + dY[dir];

            if (aX >= 0 && aX < N && aY >= 0 && aY < N) {
                board[aX][aY] += remainder;
                remainder = 0;
                printBoard();
            }

            board[r][c] = 0;

            System.out.println(r+", "+c+" : " + remainder);

            outSum += remainder;

            printBoard();
        }
    }

    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
