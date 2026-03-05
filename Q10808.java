import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] index = new int[26];

        String line = br.readLine();

        for(int i=0;i<line.length();i++){
            int a = line.charAt(i);
            index[a-97]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(index[i]+" ");
        }

        System.out.println(sb);
    }
}
