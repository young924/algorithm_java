import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하노이 탑 이동 순서

public class p11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int K = getCount(N);

        sb.append(K).append("\n");

        sb.append(move(1, 3, 2, N));

        System.out.println(sb);
    }

    public static int getCount(int n) {
        if (n == 1) return 1;
        return 2 * getCount(n-1) + 1;
    }

    public static StringBuilder move(int from, int to, int rest, int h) {
        StringBuilder sb = new StringBuilder();

        if (h == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return sb;
        }

        sb.append(move(from, rest, to, h-1));

        sb.append(from).append(" ").append(to).append("\n");

        sb.append(move(rest, to, from,h-1));

        return sb;
    }
}
