import java.util.ArrayList;
import java.util.Scanner;

// 스도쿠

public class p2580 {
    public static int[][] board = new int[9][9];
    public static ArrayList<Node> zeroList = new ArrayList<>();
    public static int zero;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int input = sc.nextInt();
                board[i][j] = input;
                if (input == 0) {
                   zeroList.add(new Node(i, j));
                }
            }
        }

        zero = zeroList.size();

        dfs(0, 0);
    }

    public static void dfs(int idx, int depth) {
        if (depth == zero) {
            printBoard();
            System.exit(0);
        } else {
            Node node = zeroList.get(idx);
            for (int val = 1; val <= 9; val++) {
                if (!isPossible(node.x, node.y, val)) continue;

                board[node.x][node.y] = val;
                dfs(idx+1, depth+1);
                board[node.x][node.y] = 0;
            }
        }
    }

    public static boolean isPossible(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == val || board[i][y] == val) return false;
        }

        for (int i = (x/3)*3; i < (x/3)*3+3; i++) {
            for (int j = (y/3)*3; j < (y/3)*3+3; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
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

class Node {
    int x;
    int y;

    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}