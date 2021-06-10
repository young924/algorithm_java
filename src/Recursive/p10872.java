import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팩토리얼

public class p10872 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fact(N));
    }

    public static int fact(int n) {
        if (n == 0 || n== 1) return 1;
        return n * fact(n-1);
    }
}
