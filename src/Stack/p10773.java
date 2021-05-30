import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 제로

public class p10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[100001];
        int top = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) top--;
            else {
                stack[top] = input;
                top++;
            }
        }

        int result = 0;

        for (int i = 0; i < top; i++) {
            result += stack[i];
        }

        System.out.println(result);
    }
}
