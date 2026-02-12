import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1629 {

    public static long power(long a, long e, long c){
        if(e==1){
            return a%c;
        }

        long temp = power(a,e/2,c);

        if(e%2 == 1){
            return (temp*temp%c)*a%c;
        }
        return temp*temp%c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(power(a, b, c));
    }
}
