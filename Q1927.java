import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()+"\n");
                }else{
                    sb.append("0\n");
                }
            }else{
                pq.offer(a);
            }
        }
        System.out.println(sb);
    }
}
