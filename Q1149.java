import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] index = new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            index[i][0] = Integer.parseInt(st.nextToken());
            index[i][1] = Integer.parseInt(st.nextToken());
            index[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][3];
        dp[0][0] = index[0][0];
        dp[0][1] = index[0][1];
        dp[0][2] = index[0][2];

        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + index[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + index[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + index[i][2];    
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            min = Math.min(min,dp[n-1][i]);
        }

        System.out.println(min);

    }
}
