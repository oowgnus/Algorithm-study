import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());


        for(int i=0;i<num;i++){
            int result = 0;
            int count = 0;
            String line = br.readLine();
            for(int j=0;j<line.length();j++){
                if(Character.toString(line.charAt(j)).equals("O")){
                    count++;
                    result += count;
                }else{
                    count = 0;
                }
            }
            System.out.println(result);
        }

    }
}
