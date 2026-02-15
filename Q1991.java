import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {
    public static int n;
    public static int[][] tree;
    public static StringBuilder sb;

    public static void pre(int start){
        if(start == -1) return;

        sb.append((char)(start+'A'));
        pre(tree[start][0]);
        pre(tree[start][1]);
    }
    public static void in(int start){
        if(start == -1) return;

        in(tree[start][0]);
        sb.append((char)(start+'A'));
        in(tree[start][1]);
    }
    public static void post(int start){
        if(start == -1) return;

        post(tree[start][0]);
        post(tree[start][1]);
        sb.append((char)(start+'A'));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            int leftn = (left=='.') ? -1 : left - 'A';
            int rightn = (right=='.') ? -1 : right - 'A';
            tree[node-'A'][0] = leftn;
            tree[node-'A'][1] = rightn;
        }

        sb = new StringBuilder();

        pre(0);
        sb.append("\n");
        in(0);
        sb.append("\n");
        post(0);

        System.out.println(sb);

    }
}
