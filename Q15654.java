import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {
  public static int n,m;
  public static int[] arr;
  public static boolean[] visited;
  public static StringBuilder sb;
  public static int[] index;

  public static void dfs(int a){
    if(a == m){
      for(int val : index){
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i=0;i<n;i++){
      if(!visited[i]){
        visited[i] = true;
        index[a] = arr[i];
        dfs(a+1);
        visited[i] = false;
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    visited = new boolean[n];
    index = new int[m];

    st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    dfs(0);

    System.out.println(sb);
  }
}
