import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15686 {

    public static List<Point> house;
    public static List<Point> chicken;
    public static int n,m,ans;
    public static boolean[] visited;

    public static void pick(int start, int count){
        if(count==m){
            calculate();
            return;
        }

        for(int i=start;i<chicken.size();i++){
            visited[i] = true;
            pick(i+1, count+1);
            visited[i] = false;
        }
    }

    public static void calculate(){
        int total = 0;
        for(Point h : house){
            int mindist = Integer.MAX_VALUE;
            for(int i=0;i<chicken.size();i++){
                if(visited[i]){
                    Point c = chicken.get(i);
                    int dist = Math.abs(h.x-c.x) + Math.abs(h.y-c.y);
                    mindist = Math.min(mindist,dist);
                }
            }
            total += mindist;
        }

        ans = Math.min(ans,total);
    }
    static class Point{
        int x,y;

        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1){
                    house.add(new Point(i, j));
                }else if(a == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];

        pick(0,0);
        
        System.out.println(ans);
    }
}
