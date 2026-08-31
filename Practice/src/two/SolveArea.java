package two;

import java.util.*;

public class SolveArea {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int m;
    static int n;
    static int[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        matrix = new int[m][n];
        visited = new boolean[m][n];

        // 1. 직사각형 먼저 칠하기
        for (int i = 0; i < k; i++) {

            st = new StringTokenizer(sc.nextLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    matrix[y][x] = 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        // 2. 전체 칸 확인
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {

                // 직사각형이거나 이미 방문했으면 무시
                if (matrix[y][x] == 1 || visited[y][x]) {
                    continue;
                }

                // 새로운 영역 발견
                result.add(bfs(x, y));
            }
        }

        // 3. 오름차순 정렬
        Collections.sort(result);

        System.out.println(result.size());

        for (int area : result) {
            System.out.print(area + " ");
        }
    }

    static int bfs(int startX, int startY) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(startX, startY));
        visited[startY][startX] = true;

        int count = 1;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // 직사각형
                if (matrix[ny][nx] == 1) {
                    continue;
                }

                // 이미 방문
                if (visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                q.offer(new Pair(nx, ny));
                count++;
            }
        }

        return count;
    }
}