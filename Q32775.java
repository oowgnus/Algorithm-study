import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q32775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(m<n){
            System.out.println("flight");
        }else{
            System.out.println("high speed rail");
        }
    }
}
