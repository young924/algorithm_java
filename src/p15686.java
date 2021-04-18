import java.util.ArrayList;
import java.util.Scanner;

// 치킨 배달

public class p15686 {
    public static int N;
    public static int M;
    public static int[][] board;
    public static ArrayList<Node15686> house = new ArrayList<>();
    public static ArrayList<Node15686> chicken = new ArrayList<>();
    public static Node15686[] selected;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N+1][N+1];
        selected = new Node15686[M];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int input = sc.nextInt();
                board[i][j] = input;
                if (input == 1) {
                    house.add(new Node15686(i, j));
                }
                if (input == 2) {
                    chicken.add(new Node15686(i, j));
                }
            }
        }

        select(0, 0);

        System.out.println(min);
    }

    public static void select(int idx, int depth) {
        if (depth == M) {
            int sum = 0;

            for (int i = 0; i < house.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    int result = calDistance(house.get(i), selected[j]);
                    if (result < minDistance) minDistance = result;
                }
                sum += minDistance;
            }

            if (sum < min) min = sum;
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            selected[depth] = chicken.get(i);
            select(i + 1, depth + 1);
        }

    }

    public static int calDistance(Node15686 h, Node15686 c) {
        return Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
    }
}

class Node15686 {
    int x;
    int y;

    Node15686 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

