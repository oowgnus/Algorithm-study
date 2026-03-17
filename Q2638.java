import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2638 {
  public static int[] dx = {0,0,1,-1};
  public static int[] dy = {1,-1,0,0};
  public static int n,m;
  public static int[][] map;
  public static boolean[][] cheese;

  public static void checkOutside(int a, int b){
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{a,b});
    cheese[a][b] = true;

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int r = curr[0];
      int c = curr[1];

      for(int i=0;i<4;i++){
        int nr = r + dx[i];
        int nc = c + dy[i];

        if(nr<1 || nr >n || nc<1 || nc>m) continue;

        if(!cheese[nr][nc] && map[nr][nc]==0){
          cheese[nr][nc] = true;
          queue.offer(new int[]{nr,nc});
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n+1][m+1];

    for(int i=1;i<=n;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=1;j<=m;j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int time = 0;
    while (true) {
      boolean flag = false;
      cheese = new boolean[n+1][m+1];
      checkOutside(1, 1);
      for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
          int count = 0;
          if(map[i][j]==1){
            flag = true;
            int r = i;
            int c = j;
            for(int h=0;h<4;h++){
              int nr = r + dx[h];
              int nc = c + dy[h];

              if(nr<1 || nr >n || nc<1 || nc>m) continue;

              if(map[nr][nc]==0 && cheese[nr][nc]){
                count++;
              }
              if(count>=2){
                map[i][j] = 2;
                break;
              }
            }
          }
          
          
        }
      }
      if(!flag){
        break;
      }
      for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
          if(map[i][j]==2){
            map[i][j] = 0;
          }
        }
      }
      time++;
    }

    System.out.println(time);
  }
}
