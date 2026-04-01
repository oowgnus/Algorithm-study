import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10942 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] index = new int[n+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1;i<=n;i++){
      index[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());
    for(int i=0;i<m;i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());


    }
  }
}
