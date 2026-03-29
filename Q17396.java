import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q17396 {
  static class Node implements Comparable<Node>{
    int target;
    long weight;

    Node(int target, long weight){
      this.target = target;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
      return Long.compare(this.weight,o.weight);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] index = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      index[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<Node>[] adj = new ArrayList[n];
    for(int i=0;i<n;i++) adj[i] = new ArrayList<>();

    for(int i=0;i<m;i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      adj[a].add(new Node(b, t));
      adj[b].add(new Node(a, t));
    }

    long[] dist = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[0] = 0;

    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.offer(new Node(0, 0));

    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      int next = curr.target;
      long d = curr.weight;

      if(dist[next] < d) continue;

      for(Node to : adj[next]){
        if(index[to.target]==1 && to.target!=n-1) continue;

        if(dist[to.target] > dist[next] + to.weight){
          dist[to.target] = dist[next] + to.weight;
          queue.offer(new Node(to.target, dist[to.target]));
        }
      }
    }

    if(dist[n-1] == Long.MAX_VALUE){
      System.out.println("-1");
    }else{
      System.out.println(dist[n-1]);
    }
  }
}
