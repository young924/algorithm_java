import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덱

public class p10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] deque = new int[20000];
        int front = 10000;
        int back = 9999;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    front--;
                    deque[front] = Integer.parseInt(st.nextToken());
                    break;
                case "push_back":
                    back++;
                    deque[back] = Integer.parseInt(st.nextToken());
                    break;
                case "pop_front":
                    if (front > back) sb.append(-1).append("\n");
                    else {
                        sb.append(deque[front]).append("\n");
                        front++;
                    }
                    break;
                case "pop_back":
                    if (front > back) sb.append(-1).append("\n");
                    else {
                        sb.append(deque[back]).append("\n");
                        back--;
                    }
                    break;
                case "size":
                    sb.append(back-front+1).append("\n");
                    break;
                case "empty":
                    if (front > back) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (front > back) sb.append(-1).append("\n");
                    else sb.append(deque[front]).append("\n");
                    break;
                case "back":
                    if (front > back) sb.append(-1).append("\n");
                    else sb.append(deque[back]).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
