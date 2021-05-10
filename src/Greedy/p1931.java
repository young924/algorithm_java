import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 회의실 배정

public class p1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        int[][] schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(schedule, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int prev = 0;

        for (int i = 0; i < N; i++) {
            if (prev <= schedule[i][0]) {
                prev = schedule[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}
