import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4963 {
    public static int w,h;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {1,1,1,0,0,-1,-1,-1};
    public static int[] dy = {1,0,-1,1,-1,1,0,-1};
    public static int count;

    public static void dfs(int x, int y){
        if(map[x][y] == 1){
            for(int i=0;i<8;i++){
                int nr = x+dx[i];
                int nc = y+dy[i];

                if(nr<1 || nr>h || nc<1 || nc>w) continue;

                if(!visited[nr][nc] && map[nr][nc] == 1){
                    visited[nr][nc] = true;
                    dfs(nr,nc);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            count = 0;

            if(w==0 && h==0){
                break;
            }

            map = new int[h+1][w+1];
            visited = new boolean[h+1][w+1];

            for(int i=1;i<=h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1;i<=h;i++){
                for(int j=1;j<=w;j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        count++;
                        visited[i][j] = true;
                        dfs(i,j);
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}