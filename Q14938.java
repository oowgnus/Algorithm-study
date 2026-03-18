import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q14938 {
  public static ArrayList<Node>[] adj;
  public static int n,m,r;
  public static int[] item;

  static class Node implements Comparable<Node>{
    int target;
    int weight;

    Node(int target, int weight){
      this.target=target;
      this.weight=weight;
    }

    @Override
    public int compareTo(Node o){
      return this.weight - o.weight;
    }
  }

  public static int djikstra(int h){
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(h,0));

    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[h] = 0;

    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      int to = curr.target;
      int d = curr.weight;

      if(dist[to] < d) continue;

      for(Node next : adj[to]){
        if(dist[next.target] > dist[to] + next.weight){
          dist[next.target] = dist[to] + next.weight;
          pq.offer(new Node(next.target, dist[next.target]));
        }
      }
    }

    int sum = 0;
    for(int i=1;i<=n;i++){
      if(dist[i] <= m){
        sum += item[i];
      }
    }

    return sum;

  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    item = new int[n+1];

    st = new StringTokenizer(br.readLine());
    for(int i=1;i<=n;i++){
      item[i] = Integer.parseInt(st.nextToken());
    }

    adj = new ArrayList[n+1];
    for(int i=1;i<=n;i++){
      adj[i] = new ArrayList<>();
    }

    for(int i=0;i<r;i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      adj[a].add(new Node(b,c));
      adj[b].add(new Node(a,c));
    }

    int result = 0;

    for(int i=1;i<=n;i++){
      result = Math.max(result, djikstra(i));
    }

    System.out.println(result);
  }
}
