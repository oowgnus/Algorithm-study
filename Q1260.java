import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
    public static int N,M,V;
    public static boolean[] flag;
    public static int[][] index;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int start){
        flag[start-1] = true;
        sb.append(start + " ");
        for(int i=0;i<N;i++){
            if(index[start-1][i] == 1 && flag[i] == false){
                dfs(i+1);
            }
        }
    }

    public static void bfs(int start){
        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        flag[start-1] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current +" ");
            for(int i=0;i<N;i++){
                if(index[current-1][i] == 1 && !flag[i]){
                    queue.offer(i+1);
                    flag[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        flag = new boolean[N];
        index = new int[N][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            index[a-1][b-1] = 1;
            index[b-1][a-1] = 1;
        }

        dfs(V);
        System.out.println(sb);
        flag = new boolean[N];
        bfs(V);
        System.out.println(sb);
    }
}