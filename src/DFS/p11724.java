import java.util.Scanner;

// 연결 요소의 개수

public class p11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Graph11724 graph = new Graph11724(N);

        for (int i = 0; i < M; i++) {
            graph.addVertex(sc.nextInt(), sc.nextInt());
        }

        graph.search();
    }
}

class Graph11724 {
    private int n;
    private int[][] graph;
    private boolean[] visited;
    private int nCC;

    public Graph11724(int n) {
        this.n = n;
        this.graph = new int[n][n];
        this.visited = new boolean[n];
        this.nCC = 0;
    }

    public void addVertex (int x, int y) {
        this.graph[x-1][y-1] = this.graph[y-1][x-1] = 1;
    }

    public void search() {
        for (int i = 0; i < this.n; i++) {
            if (!visited[i]) {
                dfs(i);
                nCC++;
            }
        }
        System.out.println(nCC);
    }

    private void dfs(int s) {
        visited[s] = true;

        for (int i = 0; i < this.n; i++) {
            if (this.graph[s][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
