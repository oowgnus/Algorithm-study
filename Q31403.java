import java.util.Scanner;

public class Q31403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();
        String C = sc.nextLine();

        int result = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
        String StringResult = A+B;
        int result2 = Integer.parseInt(StringResult) - Integer.parseInt(C);

        System.out.println(result);
        System.out.println(result2);
        sc.close();
    }
}
