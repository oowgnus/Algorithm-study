import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13549 {
    public static int solve(int n, int k){
        if(n>=k){
            return n-k;
        }
        if(k==1){
            return Math.abs(n-k);
        }
        if(k%2 == 0){
            return Math.min(k-n,solve(n,k/2));
        }else{
            return 1+ Math.min(solve(n,k+1),solve(n,k-1));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solve(N, K));
    }
}