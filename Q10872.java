import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 1;
        if(n==0){
            System.out.println(result);
            return;
        }
        for(int i=1;i<=n;i++){
            result *= i;
        }
        System.out.println(result);
    }
}
