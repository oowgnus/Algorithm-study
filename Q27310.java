import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q27310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int count = 0;

        for(int i=0;i<line.length();i++){
            if(Character.toString(line.charAt(i)).equals("_")){
                count++;
            }
        }

        int difficult = line.length()+2+(count*5);
        System.out.println(difficult);
    }
}
