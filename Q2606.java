import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606 {
    public static int N,M;
    public static boolean [] flag;
    public static boolean [][] index;
    public static int count = 0;

    static void dfs(int n){
        flag[n] = true;
        for(int i=0;i<N+1;i++){
            if(index[n][i] && !flag[i]){
                flag[i] = true;
                count++;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        flag = new boolean[N+1];
        index = new boolean[N+1][N+1];

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            index[a][b] = true;
            index[b][a] = true;
        }

        dfs(1);
        System.out.println(count);
    }
}
