import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    
    int count = 0;

    while(n-- >0){
      int target = Integer.parseInt(br.readLine());

      if(target > count){
        for(int i=count+1;i<=target;i++){
          stack.push(i);
          sb.append("+\n");
        }
        count = target;
      }else if(stack.peek() != target){
        System.out.println("NO");
        return;
      }

      stack.pop();
      sb.append("-\n");
    }

    System.out.println(sb);
  }
}