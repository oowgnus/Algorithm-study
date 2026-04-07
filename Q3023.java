import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3023 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    char[][] index = new char[r+1][c+1];
    for(int i=1;i<=r;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=1;j<=c;j++){
        index[i][j] = st.nextToken().charAt(0);
      }
    }

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    char[][] result = new char[2*r+1][2*c+1];
    for(int i=1;i<=2*r;i++){
      for(int j=1;j<=2*c;j++){
        int origI = (i<=r) ? i : (2*r+1-i);
        int origJ = (j<=c) ? j : (2*c+1-j);

        result[i][j] = result[origI][origJ];
      }
    }

    if(result[a][b] == '#') result[a][b] = '.';
    else result[a][b] = '#';

    StringBuilder sb = new StringBuilder();
    for(int i=1;i<=2*r;i++){
      for(int j=1;j<=2*c;j++){
        sb.append(result[i][j]);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
