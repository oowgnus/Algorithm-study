import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int [] index = new int[N];
        int [] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            index[i] = a;
            array[i] = a;
        }
        Arrays.sort(index);
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int rank=0;
        for(int i=0;i<index.length;i++){
            if(!map.containsKey(index[i])){
                map.put(index[i], rank);
                rank++;
            }
        }
        for(int i=0;i<array.length;i++){
            sb.append(map.get(array[i])+" ");
        }
  
        System.out.println(sb);
    }
}
