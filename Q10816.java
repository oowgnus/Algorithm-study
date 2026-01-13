import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>(N);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            int val = 1;
            if(map1.containsKey(a)){
                val = map1.get(a);
                val++;
            }
            map1.put(a, val);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            System.out.print(map1.get(Integer.parseInt(st.nextToken()))+" ");
        }
    }
}
