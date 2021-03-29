import java.util.Arrays;
import java.util.Scanner;

// 안전 영역

public class p2468 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxH = 1;
        int maxA = 0;
        int N = sc.nextInt();

        Graph2468 graph = new Graph2468(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int h = sc.nextInt();
                if (h > maxH) maxH = h;
                graph.setValue(i, j, h);
            }
        }


        for (int i = 0; i <= maxH + 1; i++) {
            int nA = graph.getNumOfArea(i);
            // System.out.println("When rain height is "+i + ", the number of areas is " + nA);
            if (maxA < nA) maxA = nA;
        }

        System.out.println(maxA);
    }
}

class Graph2468 {
    private int n;
    private int[][] graph;
    private int[][] rainGraph;
    private boolean[][] visited;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    public Graph2468(int n) {
        this.n = n;
        this.graph = new int[n][n];
        this.rainGraph = new int[n][n];
        this.visited = new boolean[n][n];
    }

    public void setValue(int x, int y, int value) {
        this.graph[x][y] = value;
    }

    private void clearVisited() {
        for (boolean a[] : visited) {
            Arrays.fill(a, false);
        }
    }

    private void printRainGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rainGraph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getNumOfArea(int rainH) {
        int nA = 0;

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.graph[i][j] <= rainH) rainGraph[i][j] = 0;
                else rainGraph[i][j] = 1;
            }
        }

        // printRainGraph();

        clearVisited();

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.rainGraph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    nA++;
                }
            }
        }

        return nA;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nX < this.n && nY >= 0 && nY < this.n) {
                if (this.rainGraph[nX][nY] == 1 && !visited[nX][nY]) {
                    dfs(nX, nY);
                }
            }
        }
    }
}