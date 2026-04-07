import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34400 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    int start = 0;
    
    for(int i=0;i<t;i++){
      int a = Integer.parseInt(br.readLine());

      
      if(a%25 < 17){
        sb.append("ONLINE").append("\n");
      }else{
        sb.append("OFFLINE").append("\n");
      }

      
    }

    System.out.println(sb);
  }
}