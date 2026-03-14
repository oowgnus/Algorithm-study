import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        int [] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[a] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int start = queue.poll();

            for(int next : adj[start]){
                if(dist[next] == -1){
                    dist[next] = dist[start] + 1;
                    queue.offer(next);
                }
            }
        }

        System.out.println(dist[b]);
    }
}
