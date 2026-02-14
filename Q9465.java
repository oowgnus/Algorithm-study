import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] index = new int[2][n];

            for(int j=0;j<2;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int h=0;h<n;h++){
                    index[j][h] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n];
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[0][0] = index[0][0];
                    dp[1][0] = index[1][0];
                }else if(j==1){
                    dp[0][1] = index[0][1] + index[1][0];
                    dp[1][1] = index[1][1] + index[0][0];
                }else{
                    dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + index[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + index[1][j];
                }
            }
            int ans = Math.max(dp[0][n-1], dp[1][n-1]);

            System.out.println(ans);
        }


    }
}
