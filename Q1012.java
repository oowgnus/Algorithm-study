import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] index = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                index[x][y] = 1;
            }

            Queue<int[]> queue = new LinkedList<>();
            int count = 0;

            for(int q=0;q<n;q++){
                for(int j=0;j<m;j++){
                    if(index[q][j] == 1 && !visited[q][j]){
                        count++;
                        queue.offer(new int[]{q,j});
                        visited[q][j] = true;

                        while (!queue.isEmpty()) {
                            int [] curr = queue.poll();
                            int r = curr[0];
                            int c = curr[1];

                            for(int h=0;h<4;h++){
                                int nr = r + dx[h];
                                int nc = c + dy[h];

                                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                                if(visited[nr][nc] || index[nr][nc] == 0) continue;

                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr,nc});
                            }
                        }

                    }
                }
            }
            System.out.println(count);
        }
    }
}