class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int current, int[][] computers) {
        
        visited[current] = true;
        
        for (int next = 0; next < computers.length; next++) {
            
            if (!visited[next] && computers[current][next] == 1) {
                dfs(next, computers);
            }
        }
    }
}