import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {
    public static int v,e,start;
    static class Node implements Comparable<Node>{
        int target;
        int weight;

        Node(int target, int weight){
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        int [] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        ArrayList<Node>[] adj = new ArrayList[v+1];
        for(int i=1;i<=v;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<=e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int now = curr.target;
            int d = curr.weight;

            if(dist[now] < d) continue;

            for(Node next : adj[now]){
                if(dist[next.target] > dist[now] + next.weight){
                    dist[next.target] = dist[now] + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=v;i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}
