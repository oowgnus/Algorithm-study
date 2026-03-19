import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2164 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    if(n==1){
      System.out.println(n);
      return;
    }

    Queue<Integer> queue = new LinkedList<>();
    for(int i=1;i<=n;i++){
      queue.offer(i);
    }

    while (true) {
      if(queue.size() == 2){
        queue.poll();
        System.out.println(queue.poll());
        return;
      }

      queue.poll();
      queue.offer(queue.poll());
    }
  }
}
