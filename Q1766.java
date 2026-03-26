import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1766 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] adj = new ArrayList[n+1];
    for(int i=1;i<=n;i++) adj[i] = new ArrayList<>();

    int[] degree = new int[n+1];

    for(int i=0;i<m;i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      adj[a].add(b);
      degree[b]++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=1;i<=n;i++){
      if(degree[i] == 0){
        pq.offer(i);
      }
    }

    boolean[] flag = new boolean[n+1];

    while (!pq.isEmpty()) {
      int curr = pq.poll();

      sb.append(curr+" ");

      for(int next : adj[curr]){
        degree[next]--;

        if(degree[next] == 0){
          pq.offer(next);
        }
      }
    }

    System.out.println(sb);
  }
}
