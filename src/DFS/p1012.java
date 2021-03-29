import java.util.Scanner;

// 유기농 배추

public class p1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            Graph1012 graph = new Graph1012(M, N);

            for (int i = 0; i < K; i++) {
                graph.addVertex(sc.nextInt(), sc.nextInt());
            }

            // graph.printGraph();

            graph.search();
        }
    }
}


class Graph1012 {
    private int m;
    private int n;
    private int[][] graph;
    private boolean[][] visited;
    private int numOfWorm;
    static private int[] dx = {0, 1, 0, -1};
    static private int[] dy = {-1, 0, 1, 0};

    public Graph1012(int m, int n) {
        this.m = m;
        this.n = n;
        this.graph = new int[m][n];
        this.visited = new boolean[m][n];
    }

    public void addVertex(int x, int y) {
        graph[x][y] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void search() {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    numOfWorm++;
                }
            }
        }
        System.out.println(numOfWorm);
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nX < m && nY >= 0 && nY < n) {
                if (this.graph[nX][nY] == 1 && !visited[nX][nY]) {
                    dfs(nX, nY);
                }
            }
        }
    }
}