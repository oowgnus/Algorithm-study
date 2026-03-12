import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q34926 {
    public static int n,k;
    public static String line;
    public static Queue<Character> queue;
    public static Character[] index;

    public static void bfs(int start){
        while (!queue.isEmpty()) {
            char a = queue.poll();
            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        line = br.readLine();
        index = new Character[line.length()];
        queue = new LinkedList<>();

        for(int i=0;i<n;i++){
          index[i] = line.charAt(i);
        }


    }
}
