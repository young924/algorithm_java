import java.util.Scanner;

// 체스판 다시 칠하기

public class p1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] boardW = new char[8][8];
        char[][] boardB = new char[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    boardW[i][j] = 'W';
                    boardB[i][j] = 'B';
                } else if (i % 2 == 0 && j % 2 == 1) {
                    boardW[i][j] = 'B';
                    boardB[i][j] = 'W';
                } else if (i % 2 == 1 && j % 2 == 1) {
                    boardW[i][j] = 'W';
                    boardB[i][j] = 'B';
                } else {
                    boardW[i][j] = 'B';
                    boardB[i][j] = 'W';
                }
            }
        }

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int min = 64;

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                int countW = 0;
                int countB = 0;

                for (int p = 0; p < 8; p++) {
                    for (int q = 0; q < 8; q++) {
                        if (boardW[p][q] != board[i+p][j+q]) countW++;
                        if (boardB[p][q] != board[i+p][j+q]) countB++;
                    }
                }

                if (countB < countW) {
                    if (countB < min) min = countB;
                } else {
                    if (countW < min) min = countW;
                }
            }
        }

        System.out.println(min);
    }
}
