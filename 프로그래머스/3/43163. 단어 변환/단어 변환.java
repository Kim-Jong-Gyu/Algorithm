import java.util.*;


class Solution {
    
    int min = 9999999;
    
    public int solution(String begin, String target, String[] words) {
        
        for(int i = 0; i < words.length; i++) {
            if(isOneDifference(begin, words[i])) {
                boolean[] visited = new boolean[words.length];
                dfs(i, target, words, 1, visited);
            }
        }
        
        return min == 9999999 ? 0 : min;
    }
    
    public void dfs(int cur, String target, String[] words, int count, boolean[] visited) {
        if(words[cur].equals(target)) {
            min = Math.min(min, count);
            return;
        }

        visited[cur] = true;
        
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && isOneDifference(words[cur], words[i])) {
                dfs(i, target, words, count + 1, visited);
            }
        }
    }
    
    public boolean isOneDifference(String a, String b) {
        int count = 0;
        
        for(int i = 0; i < a.length(); i++) {
            
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
    
}