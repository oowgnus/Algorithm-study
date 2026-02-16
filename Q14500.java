import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
    public static int[][] index;
    public static boolean[][] visited;
    public static int n,m;
    public static int max;
    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};

    public static void dfs(int r, int c, int depth, int result){

        if(depth == 4){
            max = Math.max(max, result);
            return;
        }
        for(int i=0;i<4;i++){
            int nr = r+dx[i];
            int nc = c+dy[i];

            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

            if(!visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr,nc,depth+1,result + index[nr][nc]);
                visited[nr][nc] = false;
            }
        }

    }
    public static void check(int r, int c){
        for(int i=0;i<4;i++){
            int sum = index[r][c];
            boolean flag = true;
            for(int j=0;j<3;j++){
                int cur = (i+j)%4;
                int nr = r+dx[cur];
                int nc = c+dy[cur];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    sum+=index[nr][nc];
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag) max = Math.max(max, sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        index = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                index[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = true;
                dfs(i,j,1,index[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(max);
    }
}
