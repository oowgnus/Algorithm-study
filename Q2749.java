import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2749 {
  public static long MOD = 1000000L;

  public static long[][] multiply(long[][] m1, long[][] m2){
    long[][] res = new long[2][2];

    res[0][0] = (m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0])% MOD;
    res[0][1] = (m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1])% MOD;
    res[1][0] = (m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0])% MOD;
    res[1][1] = (m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1])% MOD;

    return res;
  }

  public static long[][] pow(long[][] a, long e){
    if(e==1) return a;

    long[][] half = pow(a, e/2);

    if(e%2==0){
      return multiply(half, half);
    }else{
      return multiply(a, multiply(half, half));
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());

    long[][] a = new long[2][2];
    a[0][0] = 1;
    a[0][1] = 1;
    a[1][0] = 1;
    a[1][1] = 0;

    long[][] result = pow(a,n);

    System.out.println(result[0][1]);

  }
}