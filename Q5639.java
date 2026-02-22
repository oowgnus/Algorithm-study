import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5639 {
    public static StringBuilder sb;

    static class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val = val;
        }

        void insert(int v){
            if(v<this.val){
                if(this.left==null) this.left = new Node(v);
                else this.left.insert(v);
            }else{
                if(this.right==null) this.right = new Node(v);
                else this.right.insert(v);
            }
        }
    }

    public static void post(Node root){
        if(root == null) return;

        post(root.left);
        post(root.right);
        sb.append(root.val).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Node root = new Node(num);

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);
            root.insert(n);
        }
        sb = new StringBuilder();
        post(root);

        System.out.println(sb);
    }
}
