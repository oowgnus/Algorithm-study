import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] index = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                if(st.hasMoreTokens()){
                    index[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = index[0][0];

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + index[i][j];
                }else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + index[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + index[i][j];
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(dp[n-1][i],max);
        }

        System.out.println(max);

        
    }
}
