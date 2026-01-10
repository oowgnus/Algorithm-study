import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] index = new int [10];

        for(int i=0;i<10;i++){
            index[i] = Integer.parseInt(br.readLine())%42;
        }
        
        int count = 0;
        boolean [] list = new boolean[42];

        for(int i=0;i<10;i++){
            list[index[i]] = true;
        }

        for(int i=0;i<42;i++){
            if(list[i]){
                count++;
            }
        }

        System.out.println(count);

    }
}
