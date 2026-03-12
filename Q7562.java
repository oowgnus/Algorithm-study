import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {
    public static int[] dx = {2,1,-1,-2,-2,-1,1,2};
    public static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static int l,knightx,knighty,x,y;
    public static Queue<int[]> queue;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            int[][] map = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            knightx = Integer.parseInt(st.nextToken());
            knighty = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;

            queue = new LinkedList<>();
            queue.offer(new int[]{knightx,knighty});
            visited[knightx][knighty] = true;

            int[][] dist = new int[l][l];
            dist[knightx][knighty] = 0;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int startx = curr[0];
                int starty = curr[1];

                if(map[startx][starty]==1){
                    break;
                }

                for(int j=0;j<8;j++){
                    int nextx = startx + dx[j];
                    int nexty = starty + dy[j];

                    if(nextx<0 || nextx>=l || nexty<0 || nexty>=l) continue;

                    if(!visited[nextx][nexty]){
                        visited[nextx][nexty] = true;
                        dist[nextx][nexty] = dist[startx][starty]+1;
                        queue.offer(new int[]{nextx,nexty});
                    }
                }
            }

            System.out.println(dist[x][y]);
        }
    }
}
