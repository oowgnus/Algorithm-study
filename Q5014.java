import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
  public static int f,s,g,u,d;

  public static int bfs(int start){
    Queue<Integer> queue = new LinkedList<>();

    int[] dist = new int[f+1];
    for(int i=1;i<=f;i++) dist[i] = -1;

    queue.offer(start);
    dist[start] = 0;

    while (!queue.isEmpty()) {
      int x = queue.poll();

      if(x==g){
        return dist[x];
      }
        
      if(x+u<=f && dist[x+u]==-1){
        dist[x+u] = dist[x]+1;
        queue.offer(x+u);
      }

      if(x-d>0 && dist[x-d]==-1){
        dist[x-d] = dist[x]+1;
        queue.offer(x-d);
      }
    }
    
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    f = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    if(bfs(s)==-1){
      System.out.println("use the stairs");
    }else{
      System.out.println(bfs(s));
    }
  }
}
