class Solution {
    boolean[] visited;
    String[] move = {"+", "-"};
    int answer = 0;
    public int solve(String operator, int num1, int num2) {
        if (operator.equals("+"))
            return num1 + num2;
        return num1 - num2;
    }

    public void dfs(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length - 1){
            if(sum == target)
                answer++;
            return;
        }
        for (int i = 0; i < move.length; i++) {
            visited[idx + 1] = true;
            dfs(numbers, target, idx + 1, solve(move[i], sum , numbers[idx + 1]));
            visited[idx + 1] = false;
        }
    }

    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        dfs(numbers, target, -1, 0);
        return answer;
    }
}