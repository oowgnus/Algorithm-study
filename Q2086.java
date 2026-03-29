import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2086 {
  public static long MOD = 1000000000L;

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
    StringTokenizer st = new StringTokenizer(br.readLine());

    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    long[][] t = {{1,1},{1,0}};
    
    long result1 = pow(t,b+2)[0][1];
    long result2 = pow(t,a+1)[0][1];

    long sum = (result1-result2+MOD)%MOD;

    System.out.println(sum);

  }
}
