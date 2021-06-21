import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대공약수와 최소공배수

public class p2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int min = Math.max(num1, num2);
        int max = Math.max(num1, num2);

        for (int i = min; i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                sb.append(i).append("\n");
                break;
            }
        }

        for (int i = max; i <= num1 * num2; i += max) {
            if (i % num1 == 0 && i % num2 == 0) {
                sb.append(i);
                break;
            }
        }

        System.out.println(sb);
    }
}
