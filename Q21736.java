import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21736 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] index = new char[n][m];
        boolean [][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                index[i][j] = line.charAt(j);
                if(index[i][j] == 'I'){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;            
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int count = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr>=n || nr<0 || nc>=m || nc<0) continue;

                if(index[nr][nc] == 'O' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }else if(index[nr][nc] == 'X'){
                    continue;
                }else if(index[nr][nc] == 'P' && !visited[nr][nc]){
                    count++;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        if(count == 0){
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
    }
}