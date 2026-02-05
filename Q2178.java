import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] index = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                char c = line.charAt(j);
                String a = Character.toString(c);
                index[i][j] = Integer.parseInt(a);
                distance[i][j] = Integer.parseInt(a);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while (!queue.isEmpty()) {
            int [] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr>=n || nr<0 || nc>=m || nc<0) continue;

                if(index[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[r][c]+1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        System.out.println(distance[n-1][m-1]);
    }
}
