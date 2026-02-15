import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9019 {
    public static int a,b;
    public static boolean[] visited;
    public static class Node{
        int num;
        String cmd;

        Node(int num,String cmd){
            this.num = num;
            this.cmd = cmd;
        }
    }

    public static String bfs(int start){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start,""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.num == b) return curr.cmd;

            int result = curr.num;
            
            int d = (2*result)%10000;
            int s = (result==0) ? 9999 : result-1;
            int l = (result%1000)*10 + (result/1000);
            int r = (result%10)*1000 + (result/10);
            
            if(!visited[d]){
                visited[d] = true;
                queue.offer(new Node(d,curr.cmd+"D"));
            }
            if(!visited[s]){
                visited[s] = true;
                queue.offer(new Node(s,curr.cmd+"S"));
            }
            if(!visited[l]){
                visited[l] = true;
                queue.offer(new Node(l,curr.cmd+"L"));
            }
            if(!visited[r]){
                visited[r] = true;
                queue.offer(new Node(r,curr.cmd+"R"));
            }
        }
        return "";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new boolean[10000];
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(bfs(a));
        }
    }
}