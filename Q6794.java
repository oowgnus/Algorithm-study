import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6794 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    int count = 0;
    for(int i=0;i<=5;i++){
      for(int j=i;j<=5;j++){
        if(i+j == n){
          count++;
        }
      }
    }

    System.out.println(count);
  }
}