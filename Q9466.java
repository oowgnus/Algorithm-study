import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q9466 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for(int y=0;y<t;y++){
      int n = Integer.parseInt(br.readLine());

      int[] index = new int[n+1];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=1;i<=n;i++){
        int a = Integer.parseInt(st.nextToken());
        index[i] = a;  
      }

      int team = 0;

      for(int i=1;i<=n;i++){
        
      }
    }
  }
}
