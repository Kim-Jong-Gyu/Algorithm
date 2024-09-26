import java.util.*;

class Solution {
    
    class Node{
        
        int num;
        int cnt;
        
        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    
    public int solution(int x, int y, int n) {
        
        int min = Integer.MAX_VALUE;
        
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[y - x + 1];
        visited[0] = true;
        q.offer(new Node(x, 0));

        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.num == y){
                return now.cnt;
            }
            
            if(now.num + n <= y && !visited[now.num + n - x]){
                q.offer(new Node(now.num + n, now.cnt + 1));
                visited[now.num + n - x] = true;
            }
            if(now.num  * 2 <= y && !visited[now.num * 2 - x]){
                q.offer(new Node(now.num * 2, now.cnt + 1));
                visited[now.num * 2 - x] = true;
            }
            if(now.num * 3 <= y && !visited[now.num * 3 - x]){
                q.offer(new Node(now.num * 3, now.cnt + 1));
                visited[now.num * 3 - x] = true;
            }
        }
        return -1;
    }
}