import java.util.ArrayList;
import java.util.Scanner;

// 스타트와 링크

public class p14889 {
    public static int N;
    public static int[][] table;
    public static ArrayList<Integer> memberList1 = new ArrayList<>();
    public static ArrayList<Integer> memberList2 = new ArrayList<>();
    public static int min = 2000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        table = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        memberList1.add(0);

        dfs(0);

        System.out.println(min);
    }

    public static void dfs(int depth) {
        if (depth == N/2-1) {
            // calculate stats
            int sum1 = 0;
            int sum2 = 0;

            memberList2.clear();

            for (int m = 0; m < N; m++) {
                if (!memberList1.contains(m)) memberList2.add(m);
            }

            for (int i = 0; i < N/2 - 1; i++) {
                for (int j = i+1; j < N/2; j++) {
                    int idx1 = memberList1.get(i);
                    int idx2 = memberList1.get(j);
                    sum1 += table[idx1][idx2] + table[idx2][idx1];
                }
            }

            for (int i = 0; i < N/2 - 1; i++) {
                for (int j = i+1; j < N/2; j++) {
                    int idx1 = memberList2.get(i);
                    int idx2 = memberList2.get(j);
                    sum2 += table[idx1][idx2] + table[idx2][idx1];
                }
            }

            int result = Math.abs(sum1 - sum2);
            if (result < min) min = result;

            return;
        }

        for (int i = memberList1.get(depth)+1; i < N; i++) {
            memberList1.add(i);
            dfs(depth+1);
            memberList1.remove(memberList1.size() - 1);
        }
    }
}
