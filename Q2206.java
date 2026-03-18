import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][][] visited;
    public static int n,m;
    public static int[][] index;
    public static int result;

    public static int bfs(int x, int y, int dist, int broken){
        visited[x][y][broken] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y,dist,broken});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            int b = curr[3];
            
            if(r==n && c==m){
                return d;
            }

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr<1 || nr>n || nc<1 || nc>m) continue;

                if(!visited[nr][nc][b] && index[nr][nc]==0){
                    visited[nr][nc][b] = true;
                    queue.offer(new int[]{nr,nc,d+1,b});
                }else if(b==0 && index[nr][nc]==1){
                    if(!visited[nr][nc][1]){
                        visited[nr][nc][1] = true;
                        queue.offer(new int[]{nr,nc,d+1,1});
                    }   
                }
            }
        }
        
        return -1;
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        index = new int[n+1][m+1];
        visited = new boolean[n+1][m+1][2];


        for(int i=1;i<=n;i++){
            String line = br.readLine();
            for(int j=1;j<=m;j++){
                index[i][j] = line.charAt(j-1)-'0';
            }
        }

        System.out.println(bfs(1,1,1,0));


    }
}