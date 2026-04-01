import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10179 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    
    for(int i=0;i<t;i++){
      double price = Double.parseDouble(br.readLine());
      price = price*0.8;
      String result = String.format("%.2f", price);
      result = "$"+result;
      System.out.println(result);
    }
  }
}
