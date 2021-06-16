import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기

public class p2630 {
    public static int N;
    public static int[][] arr;
    public static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        white = 0;
        blue = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int x, int y, int size) {
        int num = arr[x][y];

        if (size == 1) {
            if (num == 1) blue++;
            else white++;
            return;
        }

        boolean done = true;

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (num != arr[i][j]) {
                    done = false;
                    break;
                }
            }
            if (!done) break;
        }

        if (done) {
            if (num == 1) blue++;
            else white++;
        } else {
            divide(x, y, size/2);
            divide(x+size/2, y, size/2);
            divide(x, y+size/2, size/2);
            divide(x+size/2, y+size/2, size/2);
        }
    }
}
