import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for(int i=0;i<testcase;i++){
            HashMap<String, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());
            int count = 1;

            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String types = st.nextToken();
                
                if(map.containsKey(types)){
                    map.put(types, map.get(types)+1);
                }else{
                    map.put(types, 1);
                }
            }

            Set<String> keys = map.keySet();
            for(String key : keys){
                int a = map.get(key);
                count = count * (a+1);
            }

            System.out.println(count-1);
        }
    }
}
