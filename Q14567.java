import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14567 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

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
    
    StringBuilder sb = new StringBuilder();

    int[] result = new int[n+1];
    Arrays.fill(result, 1);

    Queue<Integer> queue = new LinkedList<>();
    for(int i=1;i<=n;i++){
      if(degree[i]==0){
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();

      for(int next : adj[curr]){
        degree[next]--;
        result[next] = result[curr]+1;

        if(degree[next]==0){
          queue.offer(next);
        }
      }
    }

    for(int i=1;i<=n;i++){
      sb.append(result[i]+" ");
    }

    System.out.println(sb);
  }
}
