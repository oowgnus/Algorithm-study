import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11443 {
  public static long MOD = 1000000007L;

  public static long[][] multiply(long[][] m1, long[][] m2){
    long[][] res = new long[2][2];

    res[0][0] = (m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0])%MOD;
    res[0][1] = (m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1])%MOD;
    res[1][0] = (m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0])%MOD;
    res[1][1] = (m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1])%MOD;

    return res;
  }

  public static long[][] pow(long[][] a, long e){
    if(e==1){
      return a;
    }

    long[][] half = pow(a,e/2);

    if(e%2==0){
      return multiply(half, half);
    }else{
      return multiply(a, multiply(half, half));
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());

    long[][] a = {{1,1},{1,0}};
    
    long sum = 0;

    if(n%2==0){
      sum = pow(a,n+1)[1][0]-1;
    }else{
      sum = pow(a,n)[1][0]-1;
    }

    System.out.println(sum);
  }
}
