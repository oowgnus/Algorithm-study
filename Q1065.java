import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1065 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int count = 0;
    if(n>99){
      count = 99;
      for(int i=100;i<=n;i++){
        int a = i/100;
        int b = (i%100)/10;
        int c = (i%100)%10;
        
        if((a-b)==(b-c)){
          count++;
        }
      }
    }else{
      count = n;
    }

    System.out.println(count);
  }
}
