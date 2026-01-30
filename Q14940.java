import java.io.*;
import java.util.*;

public class Q14940 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];

    boolean[][] visited = new boolean[n][m];
    int[][] distance = new int[n][m];

    for (int i = 0; i < n; i++) {
      Arrays.fill(distance[i], -1);
    }

    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          queue.offer(new int[]{i, j});
          visited[i][j] = true;
          distance[i][j] = 0;
        }else if(map[i][j] == 0){
          visited[i][j] = true;
          distance[i][j] = 0;
        }
      }
    }

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    while(!queue.isEmpty()){
      int[] curr = queue.poll();
      int r = curr[0];
      int c = curr[1];
      
      for(int i=0;i<4;i++){
        int nr = r + dx[i];
        int nc = c + dy[i];

        if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

        if(visited[nr][nc] || map[nr][nc] == 0) continue;

        visited[nr][nc] = true;
        distance[nr][nc] = distance[r][c] +1;
        queue.offer(new int[]{nr,nc});
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        sb.append(distance[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}