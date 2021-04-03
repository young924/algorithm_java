import java.util.Scanner;

public class p14502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int numOfZero = 0;

        int[][] oldMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int newValue = sc.nextInt();
                oldMap[i][j] = newValue;
                if (newValue == 0) numOfZero++;
            }
        }

        int maxArea = 0;

        for (int i = 0; i < numOfZero - 2; i++) {
            for (int j = i+1; j < numOfZero - 1; j++) {
                for (int k = j+1; k < numOfZero; k++) {
                    Graph14502 newMap = new Graph14502(N, M);
                    int num = newMap.getSafeArea(oldMap, i, j, k);
                    if (num > maxArea) maxArea = num;
                }
            }
        }

        System.out.println(maxArea);
    }
}

class Graph14502 {
    private int n;
    private int m;
    private int[][] graph;
    private boolean[][] visited;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {-1, 0, 1, 0};

    public Graph14502(int n, int m) {
        this.n = n;
        this.m = m;
        this.graph = new int[n][m];
    }

    public int getSafeArea(int[][] original, int a, int b, int c) {
        this.graph = new int[this.n][this.m];
        this.visited = new boolean[this.n][this.m];
        int count = 0;

        for (int p = 0; p < this.n; p++) {
            for (int q = 0; q < this.m; q++) {
                if (original[p][q] == 0) {
                    if (count == a || count == b || count == c) {
                        graph[p][q] = 1;
                    } else graph[p][q] = 0;
                    count++;
                } else graph[p][q] = original[p][q];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2 && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    area++;
                }
            }
        }

        return area;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        graph[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nX < n && nY >= 0 && nY < m) {
                if (graph[nX][nY] == 0 && !visited[nX][nY]) {
                    dfs(nX, nY);
                }
            }
        }
    }

    private void printGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
