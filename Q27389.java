import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q27389 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());

    double result = (double)n/4;
    
    System.out.println(result);
  }
}