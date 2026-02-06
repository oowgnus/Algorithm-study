import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16928 {
    public static int n,m;
    public static HashMap<Integer, Integer> map;
    public static boolean[] visited = new boolean[101];
    public static int[] distance = new int[101];

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int r = queue.poll();
            
            for(int i=1;i<=6;i++){
                int next = r+i;
                
                if(next>100) continue;

                if(map.containsKey(next)){
                    next = map.get(next);
                }

                if(!visited[next]){
                    visited[next] = true;
                    distance[next] = distance[r]+1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(distance[100]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.put(a,b);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.put(a,b);
        }

        bfs(1);
    }
}
