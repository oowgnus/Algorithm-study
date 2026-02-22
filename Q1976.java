import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1976 {
    public static int[] parent;
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for(int j=0;j<count;j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i+1, j+1);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] visit = new int[m];
        for(int i=0;i<m;i++){
            visit[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for(int i=0;i<m-1;i++){
            if(find(visit[i]) != find(visit[i+1])){
                flag = false;
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
