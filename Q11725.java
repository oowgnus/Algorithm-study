import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] ans = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : adj[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    ans[next] = cur;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=n;i++){
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);

    }
}
