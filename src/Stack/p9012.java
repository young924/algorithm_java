import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 괄호

public class p9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            System.out.println(checkPS(br.readLine()));
        }
    }

    public static String checkPS(String s) {
        char[] arr = s.toCharArray();
        boolean[] stack = new boolean[arr.length];
        int top = 0;

        for (int i = 0; i < arr.length; i++) {
            if (top < 0) return "NO";
            if (arr[i] == '(') {
                stack[top] = true;
                top++;
            } else {
                stack[top] = false;
                top--;
            }
        }

        if (top != 0) return "NO";
        else return "YES";
    }
}
