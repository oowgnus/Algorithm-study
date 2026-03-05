import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] index = new int[6];
        int result = 0;
        for(int i=0;i<6;i++){
            index[i] = Integer.parseInt(br.readLine());
            result += index[i];
        }

        int min1 = Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            min1 = Math.min(min1, index[i]);
        }
        int min2 = Integer.MAX_VALUE;
        for(int i=4;i<6;i++){
            min2 = Math.min(min2, index[i]);
        }

        result = result - min1 - min2;

        System.out.println(result);
    }
}
