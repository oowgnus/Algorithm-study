import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q23793 {
    
    static class Node implements Comparable<Node>{
        int target;
        long weight;

        Node(int target, long weight){
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return (int)(this.weight - o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        } 

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v,w));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        long INF = 10000000001L;

        long[] dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[x] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x,0));
    
        StringBuilder sb = new StringBuilder();

        long sum = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int to = curr.target;
            long d = curr.weight;

            if(to == y){
                sum = dist[to];
                break;
            }

            if(dist[to] < d) continue;

            for(Node next : adj[to]){
                if(dist[next.target] > dist[to] + next.weight){
                    dist[next.target] = dist[to] + next.weight;
                    pq.offer(new Node(next.target, dist[next.target]));
                }
            }
        }

        if(dist[y]==INF){
            sb.append("-1 ");
        }else{
            dist = new long[n+1];
            Arrays.fill(dist, INF);
            dist[y] = 0;

            pq = new PriorityQueue<>();
            pq.offer(new Node(y,0));

            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                int to = curr.target;
                long d = curr.weight;

                if(dist[to] < d) continue;

                for(Node next : adj[to]){
                    if(dist[next.target] > dist[to] + next.weight){
                        dist[next.target] = dist[to] + next.weight;
                        pq.offer(new Node(next.target, dist[next.target]));
                    }
                }
            }
            if(dist[z] == INF){
                sb.append("-1 ");
            }else{
                sum += dist[z];
                sb.append(sum+" ");
            }

        }


        dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[x] = 0;

        pq = new PriorityQueue<>();
        pq.offer(new Node(x,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int to = curr.target;
            long d = curr.weight;

            if(to==y) continue;

            if(dist[to] < d) continue;

            for(Node next : adj[to]){
                if(next.target==y) continue;
                if(dist[next.target] > dist[to] + next.weight){
                    dist[next.target] = dist[to] + next.weight;
                    pq.offer(new Node(next.target, dist[next.target]));
                }
            }
        }

        if(dist[z] == INF){
            sb.append("-1");
        }else{
            sb.append(dist[z]);
        }

        System.out.println(sb);
    }
}
