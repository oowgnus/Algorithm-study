import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] index = new int[n+1][2];

    for(int i=1;i<=n;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0;j<2;j++){
        index[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] dp = new int[n+2];

    for(int i=n;i>0;i--){
      int l = index[i][0]+i;

      if(l <= n+1){
        dp[i] = Math.max(dp[i+1], index[i][1] + dp[l]);
      }else{
        dp[i] = dp[i+1];
      }
    }

    System.out.println(dp[1]);
  }
}
