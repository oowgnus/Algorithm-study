import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int a = (int)Math.pow(2, n);
        int half = a/2;
        int ans = 0;

        while (half >= 1) {
            if(r<half && c<half){
                
            }else if(r<half && c>=half){
                ans += half*half;
                c -= half;
            }else if(r>=half && c<half){
                ans += 2*(half*half);
                r -= half;
            }else{
                ans += 3*(half*half);
                r -= half;
                c -= half;
            }
            half /= 2;
        }


        System.out.println(ans);
        
    }
}