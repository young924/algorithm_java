import java.util.Scanner;

// 주사위 굴리기

public class p14499 {
    static int N, M, x, y, K;
    static int[][] board;
    static Dice dice;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        K = sc.nextInt();

        board = new int[N][M];
        dice = new Dice();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            solution(sc.nextInt());
//
//			System.out.println("top : "+ dice.top);
//			System.out.println("bottom : "+ dice.bottom);
//			System.out.println("north : "+ dice.north);
//			System.out.println("south : "+ dice.south);
//			System.out.println("east : "+ dice.east);
//			System.out.println("west : "+ dice.west);
        }
    }

    public static void solution(int d) {
        switch (d) {
            case 1:		// 동
                if (y+1 < M) {
                    dice.moveEast();
                    y += 1;
                    if (board[x][y] == 0) board[x][y] = dice.bottom;
                    else {
                        dice.bottom = board[x][y];
                        board[x][y] = 0;
                    }
                    System.out.println(dice.top);
                }
                break;
            case 2:		// 서
                if (y-1 >= 0) {
                    dice.moveWest();
                    y -= 1;
                    if (board[x][y] == 0) board[x][y] = dice.bottom;
                    else {
                        dice.bottom = board[x][y];
                        board[x][y] = 0;
                    }
                    System.out.println(dice.top);
                }
                break;
            case 3:		// 북
                if (x-1 >= 0) {
                    dice.moveNorth();
                    x -= 1;
                    if (board[x][y] == 0) board[x][y] = dice.bottom;
                    else {
                        dice.bottom = board[x][y];
                        board[x][y] = 0;
                    }
                    System.out.println(dice.top);
                }
                break;
            case 4:		// 남
                if (x+1 < N) {
                    dice.moveSouth();
                    x += 1;
                    if (board[x][y] == 0) board[x][y] = dice.bottom;
                    else {
                        dice.bottom = board[x][y];
                        board[x][y] = 0;
                    }
                    System.out.println(dice.top);
                }
                break;
        }
    }


}

class Dice {
    int top, bottom, north, south, east, west;

    Dice () {
        top = 0;
        bottom = 0;
        north = 0;
        south = 0;
        east = 0;
        west = 0;
    }

    void moveEast() {
        int tmp = bottom;
        bottom = east;
        east = top;
        top = west;
        west = tmp;
    }

    void moveWest() {
        int tmp = bottom;
        bottom = west;
        west = top;
        top = east;
        east = tmp;
    }

    void moveNorth() {
        int tmp = bottom;
        bottom = north;
        north = top;
        top = south;
        south = tmp;
    }

    void moveSouth() {
        int tmp = bottom;
        bottom = south;
        south = top;
        top = north;
        north = tmp;
    }
}
