import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 균형잡힌 세상

public class p4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while (true) {
            s = br.readLine();

            if (s.equals(".")) break;

            sb.append(checkString(s)).append("\n");
        }

        System.out.println(sb);
    }

    public static String checkString(String s) {
        char[] stack = new char[101];
        int top = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '.') {
                if (top == 0) return "yes";
                else return "no";
            }

            if (c == '(' || c == '[') {
                stack[top] = c;
                top++;
            } else if (c == ']') {
                if (top == 0 || stack[top-1] != '[') return "no";
                else top--;
            } else if (c == ')') {
                if (top == 0 || stack[top-1] != '(') return "no";
                else top--;
            }
        }

        return "yes";
    }
}
