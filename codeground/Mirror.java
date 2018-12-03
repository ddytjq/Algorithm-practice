import java.util.*;
public class Mirror {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    // 0 = 아래, 1 = 위, 2 = 오른쪽, 3 = 왼쪽
    public static int change_dir(int dir, int mirror) {
        if (mirror == 1) { // 좌측 하단으로 45도
            // 0 -> 3, 1 -> 2, 2 -> 1, 3 -> 0
            return 3-dir;
        } else { // 우측 하단으로 45도
            // 0 -> 2, 1 -> 3, 2 -> 0, 3 -> 1
            return (dir+2)%4;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc=1; tc<=t; tc++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            boolean[][] c = new boolean[n][n];
            sc.nextLine();
            for (int i=0; i<n; i++) {
                String s = sc.nextLine();
                for (int j=0; j<n; j++) {
                    a[i][j] = s.charAt(j) - '0';
                }
            }
            int row, col, dir;
            row = 0;
            col = 0;
            dir = 2;
            // dir
            // 0 = 아래, 1 = 위, 2 = 오른쪽, 3 = 왼쪽
            while (0 <= row && row < n && 0 <= col && col < n) {
                if (a[row][col] != 0) {
                    c[row][col] = true;
                    dir = change_dir(dir, a[row][col]);
                }
                row += dx[dir];
                col += dy[dir];
            }
            int ans = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (c[i][j]) {
                        ans += 1;
                    }
                }
            }
            System.out.println("Case #" + tc);
            System.out.println(ans);
        }
    }
}