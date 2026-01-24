import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q29863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(n>=20 && n<=23){
            int result = (24-n) + m;
            System.out.println(result);
        }else{
            int result = m-n;
            System.out.println(result);
        }
    }
}
