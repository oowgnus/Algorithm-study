import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q24937 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    n=n%10;

    Queue<Character> queue = new LinkedList<>();
    queue.offer('S');
    queue.offer('c');
    queue.offer('i');
    queue.offer('C');
    queue.offer('o');
    queue.offer('m');
    queue.offer('L');
    queue.offer('o');
    queue.offer('v');
    queue.offer('e');

    for(int i=0;i<n;i++){
      char a = queue.poll();
      queue.offer(a);
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      char a = queue.poll();
      sb.append(a);
    }

    System.out.println(sb);
  }
}
