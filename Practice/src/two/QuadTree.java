package two;

import java.util.Scanner;

public class QuadTree {

    static int n;

    static int[][] arr;

    static StringBuffer stringBuffer;

    static void main() {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        arr = new int[n][n];
        stringBuffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        conquer(0, 0, n);

        System.out.println(stringBuffer.toString());
    }

    static void conquer(int y, int x, int size) {
        // 기저 사례 : 현재 영역이 모두 같은 경우
        if (checkSame(y, x, size)) {
            stringBuffer.append(arr[y][x]);
            return;
        }

        stringBuffer.append("(");
        int half = size / 2;

        // 왼쪽 위
        conquer(y, x, half);

        // 오른쪽 위
        conquer(y, x + half, half);

        // 왼쪽 아래
        conquer(y + half, x, half);

        // 오른쪽 아래
        conquer(y + half, x + half, half);

        stringBuffer.append(")");
    }


    static boolean checkSame(int y, int x, int size) {
        int value = arr[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}
