import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Collections;
import java.util.Scanner;

// 영역 구하기

=======
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

>>>>>>> origin/master
public class p2583 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();

        Graph2583 map = new Graph2583(M, N);

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            map.paint(x1, y1, x2, y2);
        }

        // map.print();

        map.search();

        map.printResult();
    }
}

class Graph2583 {
    private int w;
    private int h;
    private int[][] graph;
    private boolean[][] visited;
    private int area;
    private ArrayList<Integer> numOfAreas;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    public Graph2583(int m, int n) {
        this.w = n;
        this.h = m;
        this.graph = new int[w][h];
        this.visited = new boolean[w][h];
        this.numOfAreas = new ArrayList<>();
    }

    public void paint(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                // System.out.println("paint "+i+" "+j);
                graph[i][j] = 1;
            }
        }
    }

    public void print() {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void search() {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (this.graph[i][j] == 0 && !visited[i][j]) {
                    area = 0;
                    dfs(i, j);
                    numOfAreas.add(area);
                }
            }
        }
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < w && nY >= 0 && nY < h) {
                if (graph[nX][nY] == 0 && !visited[nX][nY]) {
                    dfs(nX, nY);
                }
            }
        }
    }

    public void printResult() {
        Collections.sort(numOfAreas);
        System.out.println(numOfAreas.size());
        for (Integer numOfArea : numOfAreas) {
            System.out.print(numOfArea + " ");
        }
    }
}
