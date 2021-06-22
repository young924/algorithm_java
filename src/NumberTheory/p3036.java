import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 링

public class p3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N-1; i++) {
            int ring = Integer.parseInt(st.nextToken());

            int a = Math.max(first, ring);
            int b = Math.min(first, ring);

            int tmp;

            while (b > 0) {
                tmp = a % b;
                a = b;
                b = tmp;
            }

            sb.append(first/a).append("/").append(ring/a).append("\n");
        }

        System.out.println(sb);
    }
}
