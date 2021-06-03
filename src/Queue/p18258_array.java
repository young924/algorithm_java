import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 큐 2

public class p18258_array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[2000000];
        int front = -1;
        int back = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    front++;
                    queue[front] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if (front < back) sb.append(-1).append("\n");
                    else {
                        sb.append(queue[back]).append("\n");
                        back++;
                    }
                    break;
                case "size":
                    sb.append(front-back+1).append("\n");
                    break;
                case "empty":
                    if (front < back) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "back":
                    if (front < back) sb.append(-1).append("\n");
                    else sb.append(queue[front]).append("\n");
                    break;
                case "front":
                    if (front < back) sb.append(-1).append("\n");
                    else sb.append(queue[back]).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
