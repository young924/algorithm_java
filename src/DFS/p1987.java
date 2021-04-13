import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 알파벳

public class p1987 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        sc.nextLine();

        Graph1987 board = new Graph1987(R, C);

        for (int i = 0; i < R; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board.setBoardAt(i, j, s.charAt(j));
            }
        }

        board.dfs(0, 0);

        System.out.println(board.getMax());
    }
}

class Graph1987 {
    private int r;
    private int c;
    private char[][] graph;
    private ArrayList<Character> visitedList;
    private int[] dx = {0, -1, 0, 1};
    private int[] dy = {1, 0, -1, 0};
    private int max = 0;

    public Graph1987(int r, int c) {
        this.r = r;
        this.c = c;
        this.graph = new char[r][c];
        this.visitedList = new ArrayList<>();
    }

    public void setBoardAt(int x, int y, char value) {
        graph[x][y] = value;
    }

    public void print() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int x, int y) {
        visitedList.add(graph[x][y]);
        if (visitedList.size() > max) max = visitedList.size();

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nX < r && nY >= 0 && nY < c) {
                if (!visitedList.contains(graph[nX][nY])) {
                    dfs(nX, nY);
                    visitedList.remove(visitedList.size()-1);
                }
            }
        }
    }

    public int getMax() {
        return max;
    }
}