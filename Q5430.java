import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        OUTER:
        for(int i=0;i<t;i++){
            StringBuilder sb = new StringBuilder();

            String P = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line,"[],");
            for(int j=0;j<n;j++){
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            int[] index = new int[n];
            for(int j=0;j<P.length();j++){
                if(Character.toString(P.charAt(j)).equals("R")){
                    for(int h=0;h<n;h++){
                        index[h] = queue.poll();
                    }
                    for(int h=n-1;h>=0;h--){
                        queue.offer(index[h]);
                    }
                }else if(queue.isEmpty() && Character.toString(P.charAt(j)).equals("D")){
                    System.out.println("error");
                    continue OUTER;
                }else{
                    queue.poll();
                }
            }

            sb.append("[");
            for(int j=0;j<queue.size();j++){
                if(j==(queue.size()-1)){
                    sb.append(queue.poll());
                }else{
                    sb.append(queue.poll()).append(",");
                }
                
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}