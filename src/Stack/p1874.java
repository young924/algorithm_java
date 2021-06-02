import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스택 수열

public class p1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] stack = new int[N];
        int top = 0;
        int num = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            // 아직 넣지 않은 경우
            if (num <= arr[i]) {
                while (num < arr[i]) {
                    num++;
                    stack[top] = num;
                    top++;
                    sb.append("+").append("\n");
                }
            }
            // 이미 넣은 경우
            else if (top == 0 || stack[top-1] != arr[i]) {
                System.out.println("NO");
                return;
            }
            top--;
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
