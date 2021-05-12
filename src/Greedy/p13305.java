import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주유소

public class p13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        long[] distance = new long[N-1];
        long[] price = new long[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long prev = price[0];
        for (int i = 1; i < N; i++) {
            if (price[i] > prev) price[i] = prev;
            else prev = price[i];
        }

        long sum = 0;

        for (int i = 0; i < N-1; i++) {
            sum += price[i] * distance[i];
        }

        System.out.println(sum);
    }
}
