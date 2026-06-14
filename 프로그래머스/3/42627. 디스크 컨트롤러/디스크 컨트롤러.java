import java.util.*;

class Solution {
    
    class Node {    
        int number;
        int request;
        int spend;
        
        public Node(int number, int request, int spend) {
            this.number = number;
            this.request = request;
            this.spend = spend;
        }
        
    }
    
    public int solution(int[][] jobs) {
        
        // 요청 시간 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            
            // 오름차순
            if (a.spend != b.spend) {
                   return a.spend - b.spend;
            }
            
            if (a.request != b.request) {
                return a.request - b.request;
            }
            
            return a.number - b.number;
        });
        
        // 작업번호별 걸린 시간 저장
        ArrayList<Integer> li = new ArrayList<>();
        
        int time = 0;
        int idx = 0;
        int count = 0;
        int sum = 0;
        
        while(count < jobs.length) {
            
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new Node(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            Node job = pq.poll();
            
            time += job.spend;
            sum += time - job.request;
            count++;
        }
        
        return sum / jobs.length;
    }
    
    
}