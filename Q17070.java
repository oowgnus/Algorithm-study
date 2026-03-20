import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {
  public static int n;
  public static int[][] index;
  public static int count;

  public static void dfs(int r, int c, int d) {
    if (r == n && c == n) {
        count++;
        return;
    }

    if (d == 0 || d == 2) {
        if (c + 1 <= n && index[r][c + 1] == 0) {
            dfs(r, c + 1, 0);
        }
    }

    if (d == 1 || d == 2) {
        if (r + 1 <= n && index[r + 1][c] == 0) {
            dfs(r + 1, c, 1);
        }
    }

    if (r + 1 <= n && c + 1 <= n) {
        if (index[r][c + 1] == 0 && index[r + 1][c] == 0 && index[r + 1][c + 1] == 0) {
            dfs(r + 1, c + 1, 2);
        }
    }
}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    index = new int[n+1][n+1];

    for(int i=1;i<=n;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1;j<=n;j++){
        index[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    count=0;

    dfs(1,2,0);

    System.out.println(count);
  }
}
