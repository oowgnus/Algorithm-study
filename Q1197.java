import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1197 {
  public static int v,e;

  static class Node implements Comparable<Node>{
    int target;
    int weight;

    Node(int target,int weight){
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

    ArrayList<Node>[] adj = new ArrayList[v+1];
    for(int i=1;i<=v;i++){
      adj[i] = new ArrayList<>();
    }

    for(int i=0;i<e;i++){
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      adj[a].add(new Node(b,c));
      adj[b].add(new Node(a,c));
    }

    boolean[] visited = new boolean[v+1];
    
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(1,0));
    long sum = 0;

    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      int next = curr.target;
      int d = curr.weight;

      if(visited[next]) continue;

      visited[next] = true;
      sum += d;

      for(Node to : adj[next]){
        if(!visited[to.target]){
          pq.offer(to);
        }
      }
    }
    System.out.println(sum);
  }
}
