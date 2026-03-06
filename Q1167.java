import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1167 {
    public static int v;
    public static boolean[] visited;
    public static int[] dist;
    public static ArrayList<Node>[] adj;

    static class Node {
        int target;
        int weight;

        Node(int target, int weight){
            this.target = target;
            this.weight = weight;
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for(Node next : adj[curr]){
                if(!visited[next.target]){
                    visited[next.target] = true;
                    dist[next.target] = dist[curr] + next.weight;
                    queue.offer(next.target);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());

        adj = new ArrayList[v+1];
        for(int i=1;i<=v;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<v;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int vertex = Integer.parseInt(st.nextToken());
            
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                else{
                    int b = Integer.parseInt(st.nextToken());
                    adj[vertex].add(new Node(a,b));
                }
            }
        }

        visited = new boolean[v+1];
        dist = new int[v+1];
        bfs(1);
        int maxvertex = 0;
        int ex = Integer.MIN_VALUE;
        for(int i=1;i<=v;i++){
            if(ex < dist[i]){
                maxvertex = i;
                ex = dist[i];
            }
        }

        visited = new boolean[v+1];
        dist = new int[v+1];
        bfs(maxvertex);

        int result = Integer.MIN_VALUE;
        for(int i=1;i<=v;i++){
            result = Math.max(result, dist[i]);
        }

        System.out.println(result);

    }
}
