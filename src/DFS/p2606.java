import java.util.Scanner;

// 바이러스

public class p2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nN = sc.nextInt();
        int nV = sc.nextInt();

        Graph2606 graph = new Graph2606(nN);

        for (int i = 0; i < nV; i++) {
            graph.addVertex(sc.nextInt(), sc.nextInt());
        }

        graph.dfs(0);

        graph.printResult();
    }
}

class Graph2606 {
    private int n;
    private int[][] graph;
    private boolean[] visited;
    private int nC;

    public Graph2606(int n) {
        this.n = n;
        this.graph = new int[n][n];
        this.visited = new boolean[n];
        this.nC = 0;
    }

    public void addVertex (int x, int y) {
        this.graph[x-1][y-1] = this.graph[y-1][x-1] = 1;
    }

    public void printResult() {
        System.out.println(this.nC-1);
    }

    public void dfs(int s) {
        visited[s] = true;
        nC++;

        for (int i = 0; i < this.n; i++) {
            if (this.graph[s][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}