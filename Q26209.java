import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q26209 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<8;i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == 9){
                System.out.println("F");
                return;
            }
        }

        System.out.println("S");
    }
}