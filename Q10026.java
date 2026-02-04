import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q10026 {
    public static char[][] index;
    public static boolean[][] visited;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<int []> queue = new LinkedList<>();
    public static int n;

    public static void bfs(int i, int j){
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
                        
            int r = curr[0];
            int c = curr[1];

            for(int h=0;h<4;h++){
                int nr = r + dx[h];
                int nc = c + dy[h];

                if(nr>=n || nr<0 || nc>=n || nc<0) continue;

                if(index[r][c] == index[nr][nc] && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        index = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                index[i][j] = line.charAt(j);
            }
        }

        int normalcount = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    normalcount++;
                }
            }
        }

        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(index[i][j] == 'R'){
                    index[i][j] = 'G';
                }
            }
        }

        int unnormalcount = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    unnormalcount++;
                }
            }
        }

        System.out.println(normalcount+" "+unnormalcount);
    }
}
