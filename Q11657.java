import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11657 {
  static class Node{
    int target;
    int weight;

    Node(int target, int weight){
      this.target = target;
      this.weight = weight;
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
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      adj[a].add(new Node(b,c));
    }
    
    long[] dist = new long[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[1] = 0;

    for(int i=1;i<=n;i++){
      for(int j=1;j<=n;j++){
        if(dist[j] == Integer.MAX_VALUE) continue;
        
        for(Node curr : adj[j]){
          if(dist[curr.target] > dist[j] + curr.weight){
            dist[curr.target] = dist[j] + curr.weight;

            if(i==n){
              System.out.println("-1");
              return;
            }
          }
        }
      }
    }

    for(int i=2;i<=n;i++){
      if(dist[i] == Integer.MAX_VALUE){
        dist[i] = -1;
      }

      System.out.println(dist[i]);
    }

  }
}
