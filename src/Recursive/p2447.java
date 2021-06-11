import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 - 10

public class p2447 {
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        int cnt = 1;

        for (int i = 0; i < N; i += N/3) {
            for (int j = 0; j < N; j += N/3) {
                star(i, j, N/3, cnt);
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void star(int x, int y, int size, int count) {
        if (count == 5) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int cnt = 1;

        for (int i = x; i < x + size; i += size/3) {
            for (int j = y; j < y + size; j += size/3) {
                star(i, j, size/3, cnt);
                cnt++;
            }
        }
    }
}
