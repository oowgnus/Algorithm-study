import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
  public static int n;
  public static int[][] map;
  public static boolean[][] visited;
  public static int[] dx = {0,0,1,-1};
  public static int[] dy = {1,-1,0,0};
  public static int h;

  public static void dfs(int r, int c){
    for(int i=0;i<4;i++){
      int nr = r + dx[i];
      int nc = c + dy[i];

      if(nr<1 || nr>n || nc<1 || nc>n) continue;

      if(!visited[nr][nc] && map[nr][nc]>h){
        visited[nr][nc] = true;
        dfs(nr,nc);
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n+1][n+1];

    for(int i=1;i<=n;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1;j<=n;j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = Integer.MIN_VALUE;

    for(h=0;h<=100;h++){
      visited = new boolean[n+1][n+1];
      int count = 0;
      for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
          if(!visited[i][j] && map[i][j]>h){
            visited[i][j] = true;
            dfs(i,j);
            count++;
          }
        }
      }
      result = Math.max(result, count);
    }

    System.out.println(result);
  }
}
