import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0 || n == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(solve(1, n));
    }

    public static BigInteger solve(int start, int end) {
        if (start == end) {
            return BigInteger.valueOf(start);
        }

        int mid = (start + end) / 2;
        
        return solve(start, mid).multiply(solve(mid + 1, end));
    }
}