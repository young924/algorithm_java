import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오큰수

public class p17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] stack = new int[N];
        int top = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack[0] = 0;

        for (int i = 1; i < N; i++) {
            while (top >= 0 && arr[stack[top]] < arr[i]) {
                arr[stack[top]] = arr[i];
                top--;
            }
            top++;
            stack[top] = i;
        }

        for (int i = top; i >= 0; i--) {
            arr[stack[i]] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
