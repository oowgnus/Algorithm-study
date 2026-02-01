import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] index = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                index[i][j] = Integer.parseInt(st.nextToken());
                if(index[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = 1;
                }else if(index[i][j] == -1){
                    visited[i][j] = 1;
                }        
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                if(index[nr][nc] == 0){
                    index[nr][nc] = index[r][c] + 1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(index[i][j] == 0){
                    System.out.println("-1");
                    return;
                }else{
                    max = Math.max(max,index[i][j]);
                }
            }
        }

        System.out.println(max-1);
    }
}
