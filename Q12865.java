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

        int[][] index = new int[n+1][2];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            index[i][0] = w;
            index[i][1] = v;
        }

        int[][] dp = new int[n+1][k+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(index[i][0] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], index[i][1]+dp[i-1][j-index[i][0]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}