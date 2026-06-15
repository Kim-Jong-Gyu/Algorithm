import java.util.*; 

class Solution {
    
    boolean[][] visited;
    
    int[] dx = {-1, 0, 1, 0};
    
    int[] dy = {0, -1, 0, 1};
    
    int n, m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0,0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];
            
            if(y == n - 1 && x == m -1) {
                return dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                
                if(visited[ny][nx] || maps[ny][nx] == 0) {
                    continue;
                }
                
                visited[ny][nx] = true;
                q.offer(new int[]{ny,nx, dist + 1});
            }
        }
        
        return -1;
    }
    
}