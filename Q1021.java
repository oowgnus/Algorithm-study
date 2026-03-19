import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();
        for(int i=1;i<=n;i++){
            dq.add(i);
        }

        int count = 0;

        st =  new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++){
            int a = Integer.parseInt(st.nextToken());
            if(Math.abs(dq.indexOf(a)) <= Math.abs(dq.size()-dq.indexOf(a))){
                while (a!=dq.peekFirst()) {
                    dq.addLast(dq.pollFirst());
                    count++;
                }
                dq.poll();
            }else{
                while (a!=dq.peekFirst()) {
                    dq.addFirst(dq.pollLast());
                    count++;
                }
                dq.poll();
            }
        }

        System.out.println(count);
    }
}
