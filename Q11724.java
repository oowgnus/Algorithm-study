import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11724 {
    public static int[][] index;
    public static boolean[] visited;
    public static int n,m;

    public static void dfs(int start){
        visited[start] = true;
        for(int i=1;i<n+1;i++){
            if(index[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int count = 0;
        index = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            index[a][b] = 1;
            index[b][a] = 1;
        }
        
        for(int i=1;i<n+1;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
