import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1967 {
    static class Node{
        int to;
        int weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static int maxdist=0;
    public static int maxnode=1;
    public static ArrayList<Node>[] list;
    public static boolean visited[];
    public static void dfs(int node, int dist){
        if(dist>maxdist){
            maxdist=dist;
            maxnode=node;
        }

        for(Node next : list[node]){
            if(!visited[next.to]){
                visited[next.to] = true;
                dfs(next.to, dist+next.weight);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            list[parent].add(new Node(child,weight));
            list[child].add(new Node(parent,weight));
        }

        visited[1] = true;
        dfs(1,0);
        visited = new boolean[n+1];
        maxdist=0;

        visited[maxnode] = true;
        dfs(maxnode,0);

        System.out.println(maxdist);
    }
}
