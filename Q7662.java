import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<t;i++){
            int q = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int j=0;j<q;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                String A = st.nextToken();
                int B = Integer.parseInt(st.nextToken());

                if(A.equals("I")){
                    map.put(B, map.getOrDefault(B, 0)+1);
                }
                if(!map.isEmpty()){
                    if(A.equals("D") && B == 1){
                        int maxKey = map.lastKey();
                        int count = map.get(maxKey);

                        if(count == 1){
                            map.remove(maxKey);
                        }else{
                            map.put(maxKey, count-1);
                        }
                    }

                    if(A.equals("D") && B == -1){
                        int minKey = map.firstKey();
                        int count = map.get(minKey);

                        if(count == 1){
                            map.remove(minKey);
                        }else{
                            map.put(minKey, count-1);
                        }
                    }
                }

            }
            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                sb.append(map.lastKey()+" "+map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
