import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 0

public class p11047 {
    static int N, K, result;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        StringTokenizer st = new StringTokenizer(s);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;

        values = new int[K];

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = N-1; i >= 0; i--) {
            while (K >= values[i]) {
                K -= values[i];
                result++;
            }

            if (K == 0) break;
        }

        System.out.println(result);
    }
}
