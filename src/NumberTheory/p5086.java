import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배수와 약수

public class p5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) break;

            if (a > b) {
                if (a % b == 0) sb.append("multiple").append("\n");
                else sb.append("neither").append("\n");
            } else {
                if (b % a == 0) sb.append("factor").append("\n");
                else sb.append("neither").append("\n");
            }
        }

        System.out.println(sb);
    }
}
