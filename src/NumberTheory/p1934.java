import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소공배수 (유클리드 호제법)

public class p1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int a = Math.max(num1, num2);
            int b = Math.min(num1, num2);

            int tmp;

            while (b > 0) {
                tmp = a % b;
                a = b;
                b = tmp;
            }

            sb.append(num1*num2/a).append("\n");
        }

        System.out.println(sb);
    }
}
