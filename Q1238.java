import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1238 {
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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adj = new ArrayList[n+1];
        ArrayList<Node>[] adj2 = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
            adj2[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj2[b].add(new Node(a,c));
        }

        int[] dist1 = new int[n+1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[x] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int to = curr.target;
            int d = curr.weight;

            if(dist1[to] < d) continue;

            for(Node next : adj[to]){
                if(dist1[next.target] > dist1[to] + next.weight){
                    dist1[next.target] = dist1[to] + next.weight;
                    pq.offer(new Node(next.target, dist1[next.target]));
                }
            }
        }


        int[] dist2 = new int[n+1];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist2[x] = 0;

        pq = new PriorityQueue<>();
        pq.offer(new Node(x,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int to = curr.target;
            int d = curr.weight;

            if(dist2[to] < d) continue;

            for(Node next : adj2[to]){
                if(dist2[next.target] > dist2[to] + next.weight){
                    dist2[next.target] = dist2[to] + next.weight;
                    pq.offer(new Node(next.target, dist2[next.target]));
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            result = Math.max(result, dist1[i]+dist2[i]);
        }

        System.out.println(result);

        
    }
}