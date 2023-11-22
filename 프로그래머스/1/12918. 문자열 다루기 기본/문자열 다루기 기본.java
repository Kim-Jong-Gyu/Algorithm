class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > '9')
                return false;
        }
        if(arr.length != 4 && arr.length != 6)
            return false;
        return answer;
    }
}