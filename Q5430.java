import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                makeOutputString(deque, isReversed, sb);
            }
        }
        System.out.print(sb); // 최종 결과 출력
    }

    private static void makeOutputString(ArrayDeque<Integer> deque, boolean isReversed, StringBuilder sb) {
        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
    }
}