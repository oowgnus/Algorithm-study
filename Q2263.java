import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2263 {
  public static int[] inorder;
  public static int[] postorder;
  public static int n;
  public static int[] position;

  public static void recursion(int inStart, int inEnd, int postStart, int postEnd){
    if(inStart>inEnd || postStart>postEnd) return;

    int root = postorder[postEnd];

    System.out.print(root + " ");

    int rootindex = position[root];

    int leftSize = rootindex-inStart;

    recursion(inStart, rootindex-1, postStart, postStart+leftSize-1);

    recursion(rootindex+1, inEnd, postStart + leftSize, postEnd-1);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    inorder = new int[n+1];
    postorder = new int[n+1];
    position = new int[n+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1;i<=n;i++){
      inorder[i] = Integer.parseInt(st.nextToken());
      position[inorder[i]] = i;
    }

    st = new StringTokenizer(br.readLine());
    for(int i=1;i<=n;i++){
      postorder[i] = Integer.parseInt(st.nextToken());
    }

    recursion(1, n, 1, n);
  }
}
