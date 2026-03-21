import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] index = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(String str : index){
            if(line.contains(str)){
                line = line.replace(str, "*");
            }
        }

        System.out.println(line.length());
    }
}
