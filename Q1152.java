import java.io.*;
import java.util.*;

public class Q1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        String line = br.readLine();
        String [] index = new String[line.length()];

 
        for(int i = 0; i<index.length; i++){
            index[i] = Character.toString(line.charAt(i));
            if(index[i].equals(" ")){
                count++;
            } 
        }

        if(index[0].equals(" ") || index[index.length-1].equals(" ")){
            count--;
        }
        if (index[0].equals(" ") && index[index.length-1].equals(" ")) {
            count--;
        }

        System.out.println(count);

    }
}