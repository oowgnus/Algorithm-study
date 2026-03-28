import java.util.*;
import java.io.*;

public class Q3665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] rank = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) rank[i] = Integer.parseInt(st.nextToken());

            boolean[][] adj = new boolean[n + 1][n + 1];
            int[] degree = new int[n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    adj[rank[i]][rank[j]] = true;
                    degree[rank[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (adj[a][b]) {
                    adj[a][b] = false;
                    adj[b][a] = true;
                    degree[b]--;
                    degree[a]++;
                } else {
                    adj[b][a] = false;
                    adj[a][b] = true;
                    degree[a]--;
                    degree[b]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) q.offer(i);
            }

            StringBuilder sb = new StringBuilder();
            int count = 0;
            boolean isCertain = true;

            for (int i = 0; i < n; i++) {
                if (q.isEmpty()) break;

                if (q.size() > 1) {
                    isCertain = false;
                    break;
                }

                int curr = q.poll();
                sb.append(curr).append(" ");
                count++;

                for (int next = 1; next <= n; next++) {
                    if (adj[curr][next]) {
                        degree[next]--;
                        if (degree[next] == 0) q.offer(next);
                    }
                }
            }

            if (count < n) {
                System.out.println("IMPOSSIBLE");
            } else if (!isCertain) {
                System.out.println("?");
            } else {
                System.out.println(sb.toString().trim());
            }
        }
    }
}