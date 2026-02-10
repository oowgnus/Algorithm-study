import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
    public static int n,m;
    public static boolean[] visited;
    public static int[] arr;
    public static StringBuilder sb;

    public static void dfs(int a){
        if(a==m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[a] = i;
                
                dfs(a+1);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        arr = new int[m];

        dfs(0);
        
        System.out.println(sb);
    }
}
