import java.util.*;
public class Preelancer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc=1; tc<=t; tc++) {
            int n = sc.nextInt();
            int[] p = new int[n+1];
            int[] q = new int[n+1];
            int[] d = new int[n+1];
            for (int i=1; i<=n; i++) {
                p[i] = sc.nextInt();
            }
            for (int i=1; i<=n; i++) {
                q[i] = sc.nextInt();
            }
            d[1] = Math.max(p[1], q[1]);
            for (int i=2; i<=n; i++) {
                d[i] = Math.max(d[i-1]+p[i], d[i-2]+q[i]);
            }
            System.out.println("Case #" + tc);
            System.out.println(d[n]);
        }
    }
}