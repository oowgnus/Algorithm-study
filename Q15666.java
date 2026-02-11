import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15666 {
    public static int n,m;
    public static int[] arr;
    public static int[] index;
    public static StringBuilder sb;

    public static void dfs(int start, int a){
        if(a==m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for(int i=start;i<n;i++){
            if(index[i] != before){
                arr[a] = index[i];
                before = index[i];
                dfs(i,a+1);
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

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(st.nextToken());
            index[i] = a;
        }

        Arrays.sort(index);

        dfs(0,0);

        System.out.println(sb);
    }
}
