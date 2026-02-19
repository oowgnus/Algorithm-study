    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Q15650 {
        public static int n,m;
        public static StringBuilder sb;
        public static int[] arr;
        public static boolean[] visited;

        public static void dfs(int start,int a){
            if(a==m){
                for(int val : arr){
                    sb.append(val).append(" ");
                }
                sb.append("\n");
                return;
            }
            
            for(int i=start;i<=n;i++){
                arr[a] = i;
                dfs(i+1,a+1);
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[m];
            visited = new boolean[n+1];

            dfs(1,0);

            System.out.println(sb);
        }
    }