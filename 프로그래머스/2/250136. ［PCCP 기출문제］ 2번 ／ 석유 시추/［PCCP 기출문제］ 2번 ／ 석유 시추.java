import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    int n , m;
    int[] colCnt;
    int cnt;
    int startX;
    int endX;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        colCnt = new int[m];
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[j][i] == 1){
                    dfs(j, i, land);            
                    for(int k = startX; k <= endX; k++){
                        colCnt[k] += cnt;
                    }
                    cnt = 0;
                    startX = 1000;
                    endX = 0;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            answer = Math.max(answer, colCnt[i]);
        }
        return answer;
    }
    
    public void dfs(int y, int x, int[][] land){
        // visited 대신 숫자를 더한다. 
        land[y][x] += 1;
        cnt += 1;
        startX = Math.min(x, startX);
        endX = Math.max(x, endX);
        
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if(land[ny][nx] == 0 || land[ny][nx] > 1)
                continue;
            land[ny][nx] = land[y][x] + 1;
            dfs(ny, nx, land);
        }
        return;
    }
}