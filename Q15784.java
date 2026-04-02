import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15784 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int[][] index = new int[n+1][n+1];

    for(int i=1;i<=n;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=1;j<=n;j++){
        index[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int c = index[a][b];

    for(int i=1;i<=n;i++){
      if(index[i][b] > c){
        System.out.println("ANGRY");
        return;
      }
    }

    for(int i=1;i<=n;i++){
      if(index[a][i] > c){
        System.out.println("ANGRY");
        return;
      }
    }

    System.out.println("HAPPY");
  }
}
