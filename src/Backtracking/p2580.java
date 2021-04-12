import java.util.Scanner;

public class p2580 {
    public static int[][] board;
    public static int zero;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        zero = 0;
        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int input = sc.nextInt();
                board[i][j] = input;
                if (input == 0) zero++;
            }
        }

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == zero) {
            printBoard();
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == 0) {
                        fillBoard(i, j);
                        dfs(depth+1);
                    }
                }
            }
        }
    }

    public static void fillBoard(int x, int y) {
        for (int val = 1; val <= 9; val++) {
            for (int i = 0; i < 9; i++) {
                if (board[x][i] == val || board[i][y] == val) break;

                int[] nX = new int[3];
                int[] nY = new int[3];
                if (x % 3 == 0) {   // x, x+1, x+2
                    nX[0] = x;
                    nX[1] = x+1;
                    nX[2] = x+2;
                } else if (x % 3 == 1) { // x-1, x, x+1
                    nX[0] = x-1;
                    nX[1] = x;
                    nX[2] = x+1;
                } else {    // x-2, x-1, x
                    nX[0] = x-2;
                    nX[1] = x-1;
                    nX[2] = x;
                }

                if (y % 3 == 0) {   // x, x+1, x+2
                    nY[0] = y;
                    nY[1] = y+1;
                    nY[2] = y+2;
                } else if (x % 3 == 1) { // x-1, x, x+1
                    nY[0] = y-1;
                    nY[1] = y;
                    nY[2] = y+1;
                } else {    // x-2, x-1, x
                    nY[0] = y-2;
                    nY[1] = y-1;
                    nY[2] = y;
                }

                for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 2; b++) {
                        if (board[nX[a]][nY[b]] == val) break;
                    }
                }

                board[x][y] = val;
            }
            if (board[x][y] != 0) return;
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
