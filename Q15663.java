import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15663 {
    public static int n,m;
    public static int[] arr;
    public static boolean[] visited;
    public static int[] index;
    public static StringBuilder sb;

    public static void dfs(int a){
        if(a==m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for(int i=0;i<n;i++){
            if(!visited[i] && index[i] != before){
                visited[i] = true;
                arr[a] = index[i];

                before = index[i];
                
                dfs(a+1);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        index = new int[n];
        arr = new int[m];
        visited = new boolean[n+1];

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(st.nextToken());
            index[i] = a;
        }

        Arrays.sort(index);

        dfs(0);

        System.out.println(sb);
    }
}
