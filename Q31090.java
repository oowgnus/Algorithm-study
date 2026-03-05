import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int a = n%100;
            
            if((n+1)%a==0){
                System.out.println("Good");
            }else{
                System.out.println("Bye");
            }
        }
    }
}
