import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 회전하는 큐

public class p1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        LinkedList<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            q.offer(i+1);
        }

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = q.indexOf(num);

            if (index <= q.size() / 2) {
                while (q.peekFirst() != num) {
                    // rotate left
                    q.offerLast(q.pollFirst());
                    count++;
                }
            } else {
                while (q.peekFirst() != num) {
                    // rotate right
                    q.offerFirst(q.pollLast());
                    count++;
                }
            }

            // remove first
            q.pollFirst();
        }

        System.out.println(count);
    }
}
