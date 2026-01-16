import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for(int i=0;i<a;i++){
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int b = Integer.parseInt(st.nextToken());
                pq.offer(b);
                queue.offer(new int[]{j,b});
            }
            int count = 1;
            while(!queue.isEmpty()){
                if(pq.peek() == queue.peek()[1]){
                    if(M == queue.peek()[0]){
                        System.out.println(count);
                        break;
                    }else{
                        queue.poll();
                        pq.poll();
                        count++;
                    }
                }else{
                    queue.offer(queue.poll());
                }
            }
        }
    }
}