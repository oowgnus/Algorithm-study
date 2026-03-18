import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][] visited;
    public static int n,m;
    public static int[][] index;
    public static int[][] dist;

    public static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr<1 || nr>n || nc<1 || nc>m) continue;

                if(!visited[nr][nc] && index[nr][nc]==0){
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[r][c]+1;
                    queue.offer(new int[]{nr,nc});
                }else if(!visited[nr][nc] && index[nr][nc]==1 && !flag){
                    flag = true;
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[r][c]+1;
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

        index = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        dist = new int[n+1][m+1];
        dist[1][1] = 1;

        for(int i=1;i<=n;i++){
            String line = br.readLine();
            for(int j=1;j<=m;j++){
                index[i][j] = line.charAt(j-1)-'0';
            }
        }

        bfs(1,1);
        if(dist[n][m]==0){
            dist[n][m]=-1;
        }
        
        System.out.println(dist[n][m]);
    }
}