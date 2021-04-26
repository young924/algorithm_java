import java.util.Scanner;

// 모노미노도미노 2

public class p20061 {
    static int N;
    static boolean[][] full;
    static int score;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        full = new boolean[10][10];
        score = 0;

        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            // System.out.println("** "+t+", "+x+", "+y+" **");

            // 1. 옮기기
            moveBlockGreen(t, x, y);
            moveBlockBlue(t, x, y);

            // printBoard();

            // 2. 꽉 찬 줄 비우기
            eraseGreen();

            eraseBlue();

            // printBoard();

            // System.out.println("score : "+score);

            // 3. 연한 줄 처리
            handleLight();

            // printBoard();
        }

        System.out.println(score);

        System.out.println(countBlock());
    }

    public static void printBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (full[i][j]) System.out.print("O ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int countBlock() {
        int count = 0;
        for (int i = 6; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                if (full[i][j]) count++;
                if (full[j][i]) count++;
            }
        }

        return count;
    }

    public static void moveBlockGreen(int t, int x, int y) {
        if (t == 1) {

            for (int i = 6; i < 10; i++) {
                if (full[i][y]) {
                    full[i-1][y] = true;
                    return;
                }
            }

            full[9][y] = true;

        } else if (t == 2) {

            for (int i = 6; i < 10; i++) {
                if (full[i][y] || full[i][y+1]) {
                    full[i-1][y] = true;
                    full[i-1][y+1] = true;
                    return;
                }
            }

            full[9][y] = true;
            full[9][y+1] = true;
        } else {

            for (int i = 6; i < 10; i++) {
                if (full[i][y]) {
                    full[i-1][y] = true;
                    full[i-2][y] = true;
                    return;
                }
            }

            full[9][y] = true;
            full[8][y] = true;
        }
    }

    public static void moveBlockBlue(int t, int x, int y) {
        if (t == 1) {
            for (int i = 6; i < 10; i++) {
                if (full[x][i]) {
                    full[x][i-1] = true;
                    return;
                }
            }

            full[x][9] = true;
        } else if (t == 2) {

            for (int i = 6; i < 10; i++) {
                if (full[x][i]) {
                    full[x][i-1] = true;
                    full[x][i-2] = true;
                    return;
                }
            }

            full[x][9] = true;
            full[x][8] = true;
        } else {

            for (int i = 6; i < 10; i++) {
                if (full[x][i] || full[x+1][i]) {
                    full[x][i-1] = true;
                    full[x+1][i-1] = true;
                    return;
                }
            }

            full[x][9] = true;
            full[x+1][9] = true;
        }
    }

    public static void eraseGreen() {
        for (int i = 9; i > 3; i--) {

            boolean fullG = true;

            while (fullG) {
                for (int j = 0; j < 4; j++) {
                    if (!full[i][j]) {
                        fullG = false;
                        break;
                    }
                }

                if (fullG) {
                    for (int j = i; j > 3; j--) {
                        for (int k = 0; k < 4; k++) {
                            full[j][k] = full[j-1][k];
                        }
                    }

                    score++;
                }
            }

        }
    }

    public static void eraseBlue() {
        for (int i = 9; i > 3; i--) {

            boolean fullB = true;

            while (fullB) {
                for (int j = 0; j < 4; j++) {
                    if (!full[j][i]) {
                        fullB = false;
                        break;
                    }
                }


                if (fullB) {
                    for (int j = i; j > 3; j--) {
                        for (int k = 0; k < 4; k++) {
                            full[k][j] = full[k][j-1];
                        }
                    }
                    score++;
                }
            }
        }
    }

    public static void handleLight() {
        int numOfLightB = 0;
        int numOfLightG = 0;

        for (int i = 4; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (full[i][j]) {
                    numOfLightG++;
                    break;
                }
            }
        }
        for (int i = 4; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (full[j][i]) {
                    numOfLightB++;
                    break;
                }
            }
        }

        if (numOfLightG > 0) {
            for (int i = 9; i > 5; i--) {
                for (int j = 0; j < 4; j++) {
                    full[i][j] = full[i-numOfLightG][j];
                }
            }

            for (int i = 4; i <= 5; i++) {
                for (int j = 0; j < 4; j++) {
                    full[i][j] = false;
                }
            }
        }

        if (numOfLightB > 0) {
            for (int i = 9; i > 5; i--) {
                for (int j = 0; j < 4; j++) {
                    full[j][i] = full[j][i-numOfLightB];
                }
            }

            for (int i = 4; i <= 5; i++) {
                for (int j = 0; j < 4; j++) {
                    full[j][i] = false;
                }
            }
        }
    }
}
