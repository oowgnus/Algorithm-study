import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<line.length();i++){
            if(line.charAt(i) != bomb.charAt(bomb.length()-1)){
                stack.add(line.charAt(i));
            }else{
                if(stack.size() > bomb.length()){
                    
                }
            }
        }
    }
}