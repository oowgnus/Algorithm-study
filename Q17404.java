import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17404 {
  public static int[][] rgb;
  public static int n;
  public static int dist;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    rgb = new int[n+1][3];

     for(int i=1;i<=n;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0;j<3;j++){
        rgb[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    long[][] dp = new long[n+1][3];
    dp[1][0] = rgb[1][0];
    dp[1][1] = 1000*1000+1;
    dp[1][2] = 1000*1000+1;

    for(int i=2;i<=n;i++){
      dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
      dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
      dp[i][2] = rgb[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
    }

    long red = Math.min(dp[n][1],dp[n][2]);

    dp = new long[n+1][3];
    dp[1][0] = 1000*1000+1;
    dp[1][1] = rgb[1][1];
    dp[1][2] = 1000*1000+1;

    for(int i=2;i<=n;i++){
      dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
      dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
      dp[i][2] = rgb[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
    }

    long green = Math.min(dp[n][0],dp[n][2]);

    dp = new long[n+1][3];
    dp[1][0] = 1000*1000+1;
    dp[1][1] = 1000*1000+1;
    dp[1][2] = rgb[1][2];

    for(int i=2;i<=n;i++){
      dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
      dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
      dp[i][2] = rgb[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
    }

    long blue = Math.min(dp[n][1],dp[n][0]);

    red = Math.min(red, green);
    red = Math.min(red, blue);

    System.out.println(red);

  }
}
