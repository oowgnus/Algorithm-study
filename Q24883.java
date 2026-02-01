import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        if(n.equals("n") || n.equals("N")){
            System.out.println("Naver D2");
        }else{
            System.out.println("Naver Whale");
        }
    }
}
