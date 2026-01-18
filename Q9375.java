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
            int count = n;

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
            int a;
            if(keys.size() > 1){
                a = 1;
            }else{
                a = 0;
            }
            for(String key : keys){
                a = a*map.get(key);
            }

            count = count + a;
            System.out.println(count);
        }
    }
}
