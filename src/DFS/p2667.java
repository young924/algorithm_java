import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.nextLine();

        Graph2667 map = new Graph2667(N);

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] inputArray = input.split("");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(inputArray[j]);
                if (value == 1) map.addHouse(i, j);
            }
        }
        // map.printGraph();

        map.search();

        map.printResult();
    }
}

class Graph2667 {
    private int n;
    private int[][] graph;
    private boolean[][] visited;
    private ArrayList<Integer> houseArray;
    private int numOfHouse;
    static private int[] dx = {0, 1, 0, -1};
    static private int[] dy = {-1, 0, 1, 0};

    public Graph2667(int n) {
        this.n = n;
        this.graph = new int[n][n];
        this.visited = new boolean[n][n];
        this.houseArray = new ArrayList<>();
    }

    public void addHouse(int x, int y) {
        graph[x][y] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void search() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.graph[i][j] == 1 && !visited[i][j]) {
                    numOfHouse = 0;
                    dfs(i, j);
                    houseArray.add(numOfHouse);
                }
            }
        }
    }

    public void dfs(int x, int y) {
        visited[x][y] = true;
        numOfHouse++;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nX < n && nY >= 0 && nY < n) {
                if (this.graph[nX][nY] == 1 && !visited[nX][nY]) {
                    dfs(nX, nY);
                }
            }
        }
    }

    public void printResult() {
        Collections.sort(houseArray);
        System.out.println(houseArray.size());
        for (int i = 0; i < houseArray.size(); i++) {
            System.out.println(houseArray.get(i));
        }
    }
}
