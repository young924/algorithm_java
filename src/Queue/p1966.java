import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 프린터 큐

public class p1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N;
        int M;
        int[] queue;
        int front;
        int back;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            queue = new int[100000];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                queue[j] = Integer.parseInt(st.nextToken());
            }

            front = 0;
            back = N-1;

            int cnt = 0;
            int flag = M;

            while (true) {
                int maxVal = queue[front];

                for (int k = front+1; k <= back; k++) {
                    if (queue[k] > maxVal) {
                        maxVal = queue[k];
                        if (maxVal == 9) break;
                    }
                }

                while (queue[front] != maxVal) {
                    queue[back+1] = queue[front];
                    if (flag == front) flag = back+1;
                    back++;
                    front++;
                }

                front++;

                cnt++;

                if (front-1 == flag) break;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
