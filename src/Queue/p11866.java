import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 요세푸스 문제 0

public class p11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] results = new int[N];
        int[] queue = new int[2000000];
        int front = 0;
        int back = N-1;

        for (int i = 0; i < N; i++) {
            queue[i] = i+1;
        }

        sb.append("<");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K-1; j++) {
                front++;
                back++;
                queue[back] = queue[front-1];
            }
            front++;
            sb.append(queue[front-1]).append(", ");
        }

        sb.replace(sb.length()-2, sb.length(), ">");

        System.out.println(sb);
    }
}
