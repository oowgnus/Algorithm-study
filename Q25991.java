import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25991 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    double sum = 0;
    for(int i=0;i<n;i++){
      double a = Double.parseDouble(st.nextToken());
      sum += Math.pow(a, 3);
    }

    double result = Math.cbrt(sum);

    System.out.println(result);
  }
}