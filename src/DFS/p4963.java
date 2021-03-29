import java.util.Scanner;

public class p4963 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            if (w == 0 && h== 0) break;

            Graph4963 map = new Graph4963(w, h);

            for (int j = 0; j < h; j++) {
                for (int i = 0; i < w; i++) {
                    map.setLand(j, i, sc.nextInt());
                }
            }

            System.out.println(map.search());
        }
    }
}

class Graph4963 {
    private int w;
    private int h;
    private int[][] graph;
    private boolean[][] visited;
    private int numOfIslands = 0;

    public Graph4963(int w, int h) {
        this.w = w;
        this.h = h;
        this.graph = new int[h][w];
        this.visited = new boolean[h][w];
    }

    public void setLand(int x, int y, int value) {
        this.graph[x][y] = value;
    }

    public void printGraph() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int search() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(int x, int y) {
        this.visited[x][y] = true;

        if (y+1 < this.w && this.graph[x][y+1] == 1 && !visited[x][y+1]) {
            dfs(x, y+1);
        }

        if (x+1 < this.h && y+1 < this.w && this.graph[x+1][y+1] == 1 && !visited[x+1][y+1]) {
            dfs(x+1, y+1);
        }

        if (x+1 < this.h && this.graph[x+1][y] == 1 && !visited[x+1][y]) {
            dfs(x+1, y);
        }

        if (x+1 < this.h && y-1 >= 0 && this.graph[x+1][y-1] == 1 && !visited[x+1][y-1]) {
            dfs(x+1, y-1);
        }

        if (y-1 >= 0 && this.graph[x][y-1] == 1 && !visited[x][y-1]) {
            dfs(x, y-1);
        }

        if (x-1 >= 0 && y-1 >= 0 && this.graph[x-1][y-1] == 1 && !visited[x-1][y-1]) {
            dfs(x-1, y-1);
        }

        if (x-1 >= 0 && this.graph[x-1][y] == 1 && !visited[x-1][y]) {
            dfs(x-1, y);
        }

        if (x-1 >= 0 && y+1 < this.w && this.graph[x-1][y+1] == 1 && !visited[x-1][y+1]) {
            dfs(x-1, y+1);
        }
    }
}
