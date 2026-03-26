import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2623 {
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
      int num = Integer.parseInt(st.nextToken());
      int[] list = new int[num];

      for(int j=0;j<num;j++){
        list[j] = Integer.parseInt(st.nextToken());
      }

      for(int j=0;j<num-1;j++){
        int a = list[j];
        int b = list[j+1];

        adj[a].add(b);
        degree[b]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i=1;i<=n;i++){
      if(degree[i]==0){
        sb.append(i).append("\n");
        q.offer(i);
      }
    }

    while (!q.isEmpty()) {
      int curr = q.poll();

      for(int next : adj[curr]){
        degree[next]--;

        if(degree[next]==0){
          sb.append(next).append("\n");
          q.offer(next);
        }
      }
    }
    
    for(int i=1;i<=n;i++){
      if(degree[i]!=0){
        System.out.println("0");
        return;
      }
    }

    System.out.println(sb);
  }
}
