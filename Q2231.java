import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int count = 1;
        
        while (true) {
            String line = Integer.toString(count);
            int result = 0;

            for(int i=0;i<line.length();i++){
                result += Character.getNumericValue(line.charAt(i));
            }
            result += count;

            if(result == num){
                System.out.println(count);
                break;
            }else if(count > num){
                System.out.println("0");
                break;
            }
            count++;

        }
    }
}
