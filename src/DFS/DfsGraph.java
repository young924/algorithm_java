import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DfsGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nV;    // 정점의 개수
        int nE;    // 간선의 개수

        nV = sc.nextInt();    // 정점
        nE = sc.nextInt();    // 간선

        sc.nextLine();

        DfsGraphMatrix dfsM = new DfsGraphMatrix(nV);
        DfsGraphList dfsL = new DfsGraphList(nV);

        for (int i = 0; i < nE; i++) {
            String input = sc.nextLine();
            dfsM.addVertex(Integer.parseInt(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1]));
            dfsL.addVertex(Integer.parseInt(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1]));
        }

        sc.close();

        System.out.println("\n\n행\n\n");

        dfsM.printGraph();

        System.out.println();
        System.out.print("정점 1부터 탐색 : ");
        dfsM.dfs(1);

        System.out.println();
        System.out.print("정점 2부터 탐색 : ");
        dfsM.clearVisited();
        dfsM.dfs(2);

        System.out.println();
        System.out.print("정점 3부터 탐색 : ");
        dfsM.clearVisited();
        dfsM.dfs(3);

        System.out.println();
        System.out.print("정점 4부터 탐색 : ");
        dfsM.clearVisited();
        dfsM.dfs(4);

        System.out.println();
        System.out.print("정점 5부터 탐색 : ");
        dfsM.clearVisited();
        dfsM.dfs(5);

        System.out.println();
        System.out.print("정점 6부터 탐색 : ");
        dfsM.clearVisited();
        dfsM.dfs(6);

        System.out.println();
        System.out.print("정점 7부터 탐색 : ");
        dfsM.clearVisited();
        dfsM.dfs(7);

        System.out.println();
        System.out.print("정점 8부터 탐색 : ");
        dfsM.clearVisited();
        dfsM.dfs(8);

        System.out.println("\n\n인접리스트\n\n");

        dfsL.printGraph();

        System.out.println();
        System.out.print("정점 1부터 탐색 : ");
        dfsL.dfs(1);

        System.out.println();
        System.out.print("정점 2부터 탐색 : ");
        dfsL.clearVisited();
        dfsL.dfs(2);

        System.out.println();
        System.out.print("정점 3부터 탐색 : ");
        dfsL.clearVisited();
        dfsL.dfs(3);

        System.out.println();
        System.out.print("정점 4부터 탐색 : ");
        dfsL.clearVisited();
        dfsL.dfs(4);

        System.out.println();
        System.out.print("정점 5부터 탐색 : ");
        dfsL.clearVisited();
        dfsL.dfs(5);

        System.out.println();
        System.out.print("정점 6부터 탐색 : ");
        dfsL.clearVisited();
        dfsL.dfs(6);

        System.out.println();
        System.out.print("정점 7부터 탐색 : ");
        dfsL.clearVisited();
        dfsL.dfs(7);

        System.out.println();
        System.out.print("정점 8부터 탐색 : ");
        dfsL.clearVisited();
        dfsL.dfs(8);
    }
}

class DfsGraphList {
    private int n;
    private ArrayList<ArrayList<Integer>> dfsGraph;
    private boolean[] visited;

    public DfsGraphList(int n) {
        this.n = n;
        this.dfsGraph = new ArrayList<>();

        for (int i = 0; i < this.n + 1; i++) {
            this.dfsGraph.add(new ArrayList<>());
        }

        this.visited = new boolean[this.n + 1];
    }

    public ArrayList<ArrayList<Integer>> getDfsGraph() {
        return this.dfsGraph;
    }

    public ArrayList<Integer> getNode(int i) {
        return this.dfsGraph.get(i);
    }

    public void addVertex(int x, int y) {
        this.dfsGraph.get(x).add(y);
        this.dfsGraph.get(y).add(x);
    }

    public void addVertexOneWay(int x, int y) {
        this.dfsGraph.get(x).add(y);
    }

    public void printGraph() {
        for (int i = 0; i < this.dfsGraph.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");
            for (int j = 0; j < this.dfsGraph.get(i).size(); j++) {
                System.out.print(" -> " + this.dfsGraph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void clearVisited() {
        Arrays.fill(visited, false);
    }

    public void dfs(int index) {
        this.visited[index] = true;
        System.out.print(index + " ");

        for (int i : this.dfsGraph.get(index)) {
            if (!this.visited[i]) dfs(i);
        }
    }
}

class DfsGraphMatrix {
    private int n;
    private int[][] graph;
    private boolean[] visited;

    public DfsGraphMatrix(int n) {
        this.n = n;
        this.graph = new int[this.n+1][this.n+1];
        this.visited = new boolean[this.n+1];
    }

    public int[][] getGraph() {
        return this.graph;
    }

    public void addVertex(int x, int y) {
        this.graph[x][y] = this.graph[y][x] = 1;
    }

    public void addVertexOneWay(int x, int y) {
        this.graph[x][y] = 1;
    }

    public void printGraph() {
        for (int i = 1; i < this.graph.length; i++) {
            for (int j = 1; j < this.graph.length; j++) {
                System.out.print(this.graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void clearVisited() {
        Arrays.fill(visited, false);
    }

    public void dfs(int start) {
        this.visited[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i <= this.n; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
