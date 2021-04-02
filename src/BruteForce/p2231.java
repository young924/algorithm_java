import java.util.Scanner;

// 분해합

public class p2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();
        int iN = Integer.parseInt(N);
        int min = 0;

        for (int i = 0; i < iN; i++) { // N 이하의 모든 수에 대해
            String s = String.valueOf(i);   // i를 String으로 변환
            int sum = i;
            for (int j = 0; j < s.length(); j++) {
                sum += Integer.parseInt(String.valueOf(s.charAt(j)));
            }
            if (sum == iN) {
                min = i;
                break;
            }
        }
        System.out.println(min);
    }
}
