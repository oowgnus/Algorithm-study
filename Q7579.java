import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] index = new int[n+1][2];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            index[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            index[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[101][10001];

        for(int i=1;i<=n;i++){
            for(int j=0;j<=10000;j++){
                if(index[i][1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j],index[i][0]+dp[i-1][j-index[i][1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

    }
}
