import java.util.*;

class Solution {
    
    ArrayList<Integer> arr = new ArrayList<>();
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[8];
        for(int i = 0; i < numbers.length(); i++){
            go(visited, numbers, "", i + 1);
        }
        for(int i = 0; i < arr.size(); i++){
            if(check(arr.get(i)))
                answer++;
        }
        return answer;
    }
    
    public void go(boolean[] visited, String numbers, String result, int n){
        if(result.length() == n){
            int num = Integer.parseInt(result);
            if(!arr.contains(num))
                arr.add(num);
        }
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i])
                continue;
            visited[i] = true;
            result += numbers.charAt(i);
            go(visited, numbers, result, n);
            visited[i] = false;
            result = result.substring(0, result.length() - 1);
        }
    }
    
    public boolean check(int num){
        if(num < 2)
            return false;
        for(int i = 2; i * i <= num; i++){ 
            if(num % i == 0)
                return false;
        }
        return true;
    }
}