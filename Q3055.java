import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3055 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    char[][] map = new char[r+1][c+1];

    Queue<int[]> queue = new LinkedList<>();
    Queue<int[]> water = new LinkedList<>();

    boolean[][] visited1 = new boolean[r+1][c+1];
    boolean[][] visited2 = new boolean[r+1][c+1];

    int[][] dist = new int[r+1][c+1];
    for (int i = 0; i <= r; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }

    for(int i=1;i<=r;i++){
      String line = br.readLine();
      for(int j=1;j<=c;j++){
        map[i][j] = line.charAt(j-1);
        if(map[i][j] == 'S'){
          queue.offer(new int[]{i,j});
          visited1[i][j] = true;
        }else if(map[i][j] == '*'){
          water.offer(new int[]{i,j});
          visited2[i][j] = true;
          dist[i][j] = 0;
        }
      }
    }

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    while (!water.isEmpty()) {
      int[] curr = water.poll();
      int x = curr[0];
      int y = curr[1];

      for(int i=0;i<4;i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx<1 || nx>r || ny<1 || ny>c) continue;

        if((map[nx][ny]=='.' || map[nx][ny]=='S') && !visited2[nx][ny]){
          visited2[nx][ny] = true;
          dist[nx][ny] = dist[x][y] + 1;
          water.offer(new int[]{nx,ny});
        }
      }
    }

    int[][] move = new int[r+1][c+1];

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int x = curr[0];
      int y = curr[1];

      if(map[x][y] == 'D'){
        System.out.println(move[x][y]);
        return;
      }

      for(int i=0;i<4;i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx<1 || nx>r || ny<1 || ny>c) continue;

        if((map[nx][ny]=='.' || map[nx][ny]=='D') && !visited1[nx][ny] && dist[nx][ny] > move[x][y]+1){
          visited1[nx][ny] = true;
          move[nx][ny] = move[x][y] + 1;
          queue.offer(new int[]{nx,ny});
        }
      }
    }

    System.out.println("KAKTUS");

  }
}