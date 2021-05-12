import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스택

public class p10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        int[] stack = new int[N];
        int size = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack[size] = Integer.parseInt(st.nextToken());
                    size++;
                    break;
                case "pop":
                    if (size == 0) sb.append(-1).append('\n');
                    else {
                        sb.append(stack[size-1]).append('\n');
                        size--;
                    }
                    break;
                case "size":
                    sb.append(size).append('\n');
                    break;
                case "empty":
                    if (size == 0) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "top":
                    if (size == 0) sb.append(-1).append('\n');
                    else sb.append(stack[size-1]).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}
