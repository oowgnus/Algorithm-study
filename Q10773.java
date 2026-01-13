import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] index = new int[N];

        for(int i=0;i<N;i++){
            index[i] = Integer.parseInt(br.readLine());
            if(index[i] == 0){
                for(int k=i-1;k>=0;k--){
                    if(index[k] != 0){
                        index[k] = 0;
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }
        int result = 0;
        for(int i=0;i<N;i++){
            result += index[i];
        }
        System.out.println(result);
    }
}
