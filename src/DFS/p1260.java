import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// DFS와 BFS

public class p1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        Graph1260 graph = new Graph1260(N);

        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph.addVertex(n1, n2);
        }

        graph.dfs(V);
        System.out.println();
        graph.clearVisited();
        graph.bfs(V);
    }
}

class Graph1260 {
    private int nN;
    private int[][] graph;
    private boolean[] visited;

    public Graph1260(int nN) {
        this.nN = nN;
        this.graph = new int[nN+1][nN+1];
        this.visited = new boolean[nN+1];
    }

    public void addVertex(int x, int y) {
        this.graph[x][y] = this.graph[y][x] = 1;
    }

    public void clearVisited() {
        Arrays.fill(visited, false);
    }

    public void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= nN; i++) {
            if (graph[start][i] == 1 & !visited[i]) {
                dfs(i);
            }
        }
    }

    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            System.out.print(start + " ");

            for (int i = 1; i <= nN; i++) {
                if (this.graph[start][i] == 1 & !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}