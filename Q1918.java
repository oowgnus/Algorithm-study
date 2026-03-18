import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1918 {

    public static int priority(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        if (op == '(' || op == ')') return 0;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<line.length();i++){
            char a = line.charAt(i);
            if(a=='('){
                stack.push(a);
            }else if(a==')'){
                while (!stack.isEmpty()) {
                    char b = stack.pop();
                    if(b=='(') break;
                    sb.append(b);
                }
            }else if (a == '+' || a == '-' || a == '*' || a == '/') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(a)) {
                    sb.append(stack.pop());
                }
                stack.push(a);
            }else{
                sb.append(a);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}