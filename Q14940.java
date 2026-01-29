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
  }
}