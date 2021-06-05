import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카드2

public class p2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] q = new int[2000000];

        for (int i = 0; i < N; i++) {
            q[i] = i+1;
        }

        int front = 0;
        int back = N-1;

        while (front != back) {
            front++;
            q[back+1] = q[front];
            front++;
            back++;
        }

        System.out.println(q[front]);
    }
}
