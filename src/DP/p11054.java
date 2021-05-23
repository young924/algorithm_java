import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열

public class p11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];
        int[] LDS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        // LDS
        for (int i = N-1; i >= 0; i--) {
            LDS[i] = 1;

            for (int j = N-1; j > i; j--) {
                if (arr[j] < arr[i] && LDS[i] < LDS[j] + 1) {
                    LDS[i] = LDS[j] + 1;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (LIS[i] + LDS[i] > result) result = LIS[i] + LDS[i];
        }

        System.out.println(result-1);
    }
}
