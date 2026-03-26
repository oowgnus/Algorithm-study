import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1516 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer>[] adj = new ArrayList[n+1];
    for(int i=1;i<=n;i++){
      adj[i] = new ArrayList<>();
    }

    int[] degree = new int[n+1];
    int[] time = new int[n+1];

    for(int i=1;i<=n;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      time[i] = Integer.parseInt(st.nextToken());
      
      while (st.hasMoreTokens()) {
        int a = Integer.parseInt(st.nextToken());
        if(a==-1) break;
        else{
          adj[a].add(i);
          degree[i]++;
        }
      }
    }

    int[] dp = new int[n+1];
    Arrays.fill(dp, Integer.MIN_VALUE);

    Queue<Integer> queue = new LinkedList<>();
    for(int i=1;i<=n;i++){
      if(degree[i]==0){
        dp[i] = time[i];
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();

      for(int next : adj[curr]){
        degree[next]--;
        dp[next] = Math.max(dp[next], dp[curr] + time[next]);

        if(degree[next]==0){
          queue.offer(next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=1;i<=n;i++){
      sb.append(dp[i]).append("\n");
    }
    
    System.out.println(sb);
  }
}
