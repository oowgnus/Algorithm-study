import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] index = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            index[i][0] = Integer.parseInt(st.nextToken());
            index[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][k+1];

        for(int i=1;i<=n;i++){
            int weight = index[i-1][0];
            int value = index[i-1][1];

            for(int j=1;j<=k;j++){
                if(weight <= j){
                    dp[i][j] = Math.max(dp[i-1][j], value+dp[i-1][j-weight]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
