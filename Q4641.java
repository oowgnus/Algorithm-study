import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q4641 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      boolean[] flag = new boolean[101];
      int count = 0;

      while (st.hasMoreTokens()) {
        int a = Integer.parseInt(st.nextToken());
        if(a==-1){
          System.out.println(sb);
          return;
        }else{
          flag[a] = true;
        }
      }

      for(int i=1;i<=50;i++){
        if(flag[i] && flag[2*i]){
          count++;
        }
      }

      sb.append(count).append("\n");
    }
  }
}
