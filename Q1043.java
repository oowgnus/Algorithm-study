import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1043 {
  public static int[] parent;

  public static int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  public static void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
        parent[rootY] = rootX;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    parent = new int[n+1];
    for(int i=1;i<=n;i++) parent[i] = i;

    st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    if(t==0){
      System.out.println(m);
      return;
    }

    int[] truthPeople = new int[t];
    for (int i = 0; i < t; i++) {
      truthPeople[i] = Integer.parseInt(st.nextToken());
    }

    int[][] parties = new int[m][];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      parties[i] = new int[num];
            
      for (int j = 0; j < num; j++) {
        parties[i][j] = Integer.parseInt(st.nextToken());
      }
      for (int j = 1; j < num; j++) {
        union(parties[i][0], parties[i][j]);
      }
    }

    for (int i = 1; i < t; i++) {
      union(truthPeople[0], truthPeople[i]);
    }

    int count = 0;
    for (int i = 0; i < m; i++) {
      boolean canLie = true;
      for (int person : parties[i]) {
        if (find(person) == find(truthPeople[0])) {
          canLie = false;
          break;
        }
      }
      if (canLie) count++;
    }

    System.out.println(count);
  }
}
