import java.util.*;

public class BfsGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nN = sc.nextInt();
        int nM = sc.nextInt();
        int nV = sc.nextInt();

        BfsGraphMatrix bfsM = new BfsGraphMatrix(nN);
        BfsGraphList bfsL = new BfsGraphList(nN);

        for (int i = 0; i < nM; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            bfsM.addVertex(v1, v2);
            bfsL.addVertex(v1, v2);
        }
        System.out.println("\n\n인접 행\n\n");

        bfsM.printGraph();

        System.out.print("정점 " + nV + "부터 탐색 : ");
        bfsM.bfs(nV);

        System.out.println("\n\n인접 리스트\n\n");

        bfsL.printGraph();

        System.out.printf("정점 %d 부터 탐색 : ", nV);
        bfsL.bfs(nV);
    }
}

class BfsGraphList {
    private int n;
    private LinkedList<Integer>[] graph;
    private boolean[] visited;

    public BfsGraphList(int n) {
        this.n = n;
        this.graph = new LinkedList[n+1];
        this.visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            this.graph[i] = new LinkedList<>();
        }
    }

    public void addVertex(int x, int y) {
        this.graph[x].add(y);
        this.graph[y].add(x);
    }

    public void printGraph() {
        for (int i = 1; i < this.graph.length; i++) {
            System.out.print("노드 " + i + " : ");
            Collections.sort(this.graph[i]);
            for (int j = 0; j < this.graph[i].size(); j++) {
                System.out.print(this.graph[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();

        q.add(index);
        this.visited[index] = true;

        while (!q.isEmpty()) {
            index = q.poll();
            System.out.print(index + " ");

            Iterator<Integer> iter = this.graph[index].listIterator();

            while(iter.hasNext()) {
                int w = iter.next();
                if(!visited[w]) {
                    q.add(w);
                    visited[w] = true;
                }
            }
        }
    }
}

class BfsGraphMatrix {
    private int n;
    private int[][] graph;
    private boolean[] visited;

    public BfsGraphMatrix(int n) {
        this.n = n;
        this.graph = new int[n+1][n+1];
        this.visited = new boolean[n+1];
    }

    public void addVertex(int x, int y) {
        this.graph[x][y] = this.graph[y][x] = 1;
    }

    public void printGraph() {
        for (int i = 1; i < this.graph.length; i++) {
            for (int j = 1; j < this.graph.length; j++) {
                System.out.print(this.graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();

        q.add(index);
        this.visited[index] = true;

        while (!q.isEmpty()) {
            index = q.poll();
            System.out.print(index + " ");

            for (int i = 1; i <= this.n; i++) {
                if (this.graph[index][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}