import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] index = new int[8];

        for(int i=0;i<8;i++){
            index[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        boolean flag = true;

        for(int i=0;i<7;i++){
            if(index[i]+1 == index[i+1] || index[i] -1 == index[i+1]){
                flag = true;
            }else{
                flag = false;
                break;
            }
        }

        if(flag){
            if(index[0]+1 == index[1]){
                System.out.println("ascending");
            }else if(index[0]-1 == index[1]){
                System.out.println("descending");
            }
        }else{
            System.out.println("mixed");
        }
    }
}
