import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int [] index  = new int[line.length()];

        int result = 0;
        int count = 0;

        for(int i=0;i<index.length;i++){
            String text = Character.toString(line.charAt(i));
            if(text.equals("*")){
                count = i;
                continue;
            }
            index[i] = Integer.parseInt(text);
            if(i%2 == 0){
                result += index[i]*1;
            }else{
                result += index[i]*3;
            }
        }
        int ar = 0;
        for(int i=0;i<10;i++){
            if(count%2 == 0){
                if((i+result)%10 == 0){
                    ar = i;
                    break;
                }
            }else{
                if((3*i+result)%10 == 0){
                    ar = i;
                    break;
                }
            }
        }
        

        System.out.println(ar);

    }
}