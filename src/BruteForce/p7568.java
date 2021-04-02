import java.util.Scanner;

// 덩치

public class p7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] result = new int[N];
        int[] arrX = new int[N];
        int[] arrY = new int[N];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrX[i] = x;
            arrY[i] = y;
            result[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arrX[i] < arrX[j] && arrY[i] < arrY[j]) {
                    result[i]++;
                } else if (arrX[i] > arrX[j] && arrY[i] > arrY[j]) {
                    result[j]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
