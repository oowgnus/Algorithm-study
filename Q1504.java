import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1504 {
    public static int n,e;
    public static ArrayList<Node>[] adj;

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    public static int[] dijkstra(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            int target = curr.to;
            int d = curr.weight;

            if(dist[target] < d) continue;
            
            for(Node next : adj[target]){
                if(dist[next.to] > dist[target] + next.weight){
                    dist[next.to] = dist[target] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++) adj[i] = new ArrayList<>();

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));    
            adj[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distfrom1 = dijkstra(1);
        int[] distfromv1 = dijkstra(v1);
        int[] distfromv2 = dijkstra(v2);

        long path1 = (long)distfrom1[v1] + distfromv1[v2] + distfromv2[n];
        long path2 = (long)distfrom1[v2] + distfromv2[v1] + distfromv1[n];

        long result = Math.min(path1, path2);

        if(result >= 20000000) System.out.println("-1");
        else System.out.println(result);

    }
}
