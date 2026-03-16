import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1865 {

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
      int tc = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();

      for(int u=0;u<tc;u++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
          adj[i] = new ArrayList<>();
        }

        for(int j=0;j<m;j++){
          st = new StringTokenizer(br.readLine());
          int s = Integer.parseInt(st.nextToken());
          int e = Integer.parseInt(st.nextToken());
          int t = Integer.parseInt(st.nextToken());

          adj[s].add(new Node(e,t));
          adj[e].add(new Node(s,t));
        }

        for(int j=0;j<w;j++){
          st = new StringTokenizer(br.readLine());
          int s = Integer.parseInt(st.nextToken());
          int e = Integer.parseInt(st.nextToken());
          int t = Integer.parseInt(st.nextToken());

          adj[s].add(new Node(e,-t));
        }

        int[] dist = new int[n+1];
        boolean flag = false;

        for(int j=1;j<=n;j++){
            for(int i=1;i<=n;i++){
            for(Node curr : adj[i]){
              if(dist[curr.target] > dist[i] + curr.weight){
                dist[curr.target] = dist[i] + curr.weight;

                if(j==n){
                  flag = true;
                }
              }
            }
          }
        }

        if(flag){
          sb.append("YES").append("\n");
        }else{
          sb.append("NO").append("\n");
        }
      }
      System.out.println(sb);
  }
}