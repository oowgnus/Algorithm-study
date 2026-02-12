import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int count = 0;
        
        while (true) {
            if(b==a){
                break;
            }else if(b<a){
                System.out.println("-1");
                return;
            }

            if(b%10 == 1){
                b /= 10;
                count++;
            }else if(b%2 == 0){
                b /= 2;
                count++;
            }else{
                System.out.println("-1");
                return;
            }
        }

        System.out.println(count+1);
    }
}
