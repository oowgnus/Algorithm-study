import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=0;i<9;i++){
            int a = Integer.parseInt(br.readLine());
            sum += a;
        }

        System.out.println(total-sum);
    }
}
