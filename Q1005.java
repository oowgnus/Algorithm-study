import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1005 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for(int u=0;u<t;u++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      ArrayList<Integer>[] adj = new ArrayList[n+1];
      for(int i=1;i<=n;i++){
        adj[i] = new ArrayList<>();
      }

      int[] degree = new int[n+1];
      int[] time = new int[n+1];

      st = new StringTokenizer(br.readLine());
      for(int i=1;i<=n;i++){
        time[i] = Integer.parseInt(st.nextToken());
      }

      for(int i=0;i<k;i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        adj[a].add(b);
        degree[b]++;
      }

      int[] dp = new int[n+1];
      for(int i=1;i<=n;i++){
        dp[i] = time[i];
      }

      Queue<Integer> queue = new LinkedList<>();
      for(int i=1;i<=n;i++){
        if(degree[i] == 0){
          queue.offer(i);
        }
      }

      int w = Integer.parseInt(br.readLine());

      while (!queue.isEmpty()) {
        int curr = queue.poll();

        if(curr == w) break;

        for(int next : adj[curr]){
          dp[next] = Math.max(dp[next], dp[curr] + time[next]);

          degree[next]--;

          if(degree[next] == 0){
            queue.offer(next);
          }
        }
      }

      sb.append(dp[w]).append("\n");
    }

    System.out.println(sb);
  }
}
