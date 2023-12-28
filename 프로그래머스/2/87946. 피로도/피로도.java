class Solution {
    int answer = 0;
    boolean[] visited = new boolean[10];
    public void dfs(int depth, int[][] dungeons, int fatigue){
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] || dungeons[i][0] > fatigue){
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, dungeons, fatigue - dungeons[i][1]);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
    
    public int solution(int k, int[][] dungeons) {
        dfs(0, dungeons, k);
        return answer;
    }
}