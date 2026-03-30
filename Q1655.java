import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q1655 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int i=0;i<n;i++){
      int[] list = new int[n+1];
      int a = Integer.parseInt(br.readLine());
      pq.offer(a);

      
    }
  }
}
