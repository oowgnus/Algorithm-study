import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15829 {
    static long getHash(String line, int [] index){

        int r = 31;
        int M = 1234567891;
        
        long result = 0;
        for(int i=0;i<index.length;i++){
            index[i] = line.charAt(i) - 96;
            long mul = 1;

            for(int j=0;j<i;j++){
                if(i == 0){
                    break;
                }
                mul *= r;
                mul %= M;
            }
            result = (result + mul * index[i]) % M;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int [] index = new int[num];
        String line = br.readLine();
        
        System.out.println(getHash(line, index));
        
    }
}
