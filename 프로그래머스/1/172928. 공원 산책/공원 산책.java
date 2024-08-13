import java.util.*;

class Solution {
    
    Pair now;
    int wid, len;
    char[][] mp;
    
    public int[] solution(String[] park, String[] routes) {
        wid = park[0].length();
        len = park.length;
        mp = new char[len][wid];
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                mp[i][j] = park[i].charAt(j);
                if(mp[i][j] == 'S')
                    now = new Pair(i, j);
            }
        }
        
        for(String route : routes){
            Pair next = go(route);
            now.x = next.x;
            now.y = next.y;
        }
        return new int[]{now.y, now.x};
    }
    
    public Pair go(String route){
        int x = now.x;
        int y = now.y;
        int cnt = route.charAt(2) - '0';
        while(cnt != 0){
            if(route.charAt(0) == 'E')
                x += 1; 
            if(route.charAt(0) == 'S')
                y += 1;
            if(route.charAt(0) == 'W')
                x -= 1;
            if(route.charAt(0) == 'N')
                y -= 1;
            if(x >= wid || x < 0 || y >= len || y < 0)
                return new Pair(now.y, now.x);
            if(mp[y][x] == 'X')
                return new Pair(now.y, now.x);
            cnt--;
        }
        return new Pair(y, x);
    }
    
    
    static class Pair{
        private int y;
        private int x;
        
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
        
    }
}