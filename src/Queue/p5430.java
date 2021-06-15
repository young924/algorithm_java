import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// AC

public class p5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String n = br.readLine();

            n = n.substring(1, n.length() - 1);
            StringTokenizer st = new StringTokenizer(n, ",");

            int[] arr = new int[len];
            int front = 0;
            int back = len-1;
            boolean dir = true; // if false, need to swap front <-> back
            boolean error = false;

            for (int j = 0; j < len; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    dir = !dir;
                    continue;
                }

                if (front > back) {
                    sb.append("error\n");
                    error = true;
                    break;
                }

                if (dir) front++;
                else back--;
            }

            if (error) {
                error = false;
                continue;
            }

            sb.append("[");

            if (dir) {
                for (int j = front; j <= back; j++) {
                    sb.append(arr[j]).append(",");
                }
            } else {
                for (int j = back; j >= front; j--) {
                    sb.append(arr[j]).append(",");
                }
            }

            if (sb.charAt(sb.length()-1) == ',') {
                sb.replace(sb.length()-1, sb.length(), "]\n");

            } else {
                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}
