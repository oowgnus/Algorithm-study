import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        char [] index = new char[line.length()];

        int [] alphabet = new int[26];
        for(int i=0;i<26;i++){
            alphabet[i] = -1;
        }
        for(int i=0;i<line.length();i++){
            index[i] = line.charAt(i);
        }
        for(int i=0;i<line.length();i++){
            if(alphabet[index[i]-97] != -1){
                continue;
            }
            alphabet[index[i]-97] = i;
        }

        for(int i=0;i<26;i++){
            System.out.print(alphabet[i]+" ");
        }


    }
}
