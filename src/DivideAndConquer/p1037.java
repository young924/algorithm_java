import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 약수

public class p1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = 1;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input < min) min = input;
            if (input > max) max = input;
        }

        System.out.println(min * max);
    }
}
