class Solution {
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        int[] result = new int[4];
        char[][] charBox = {
            {'R', 'T'},
            {'C', 'F'},
            {'J', 'M'},
            {'A', 'N'}
        };
        for(int i = 0; i < choices.length; i++){
            int idx = getIdx(survey[i].charAt(0));
            if((int)survey[i].charAt(0) - (int)survey[i].charAt(1) < 0)
                result[idx] += choices[i] - 4;
            else
                result[idx] += 4 - choices[i]; 
        }
        for(int i = 0; i < 4; i++){
            if(result[i] > 0)
                sb.append(charBox[i][1]);
            else{
                sb.append(charBox[i][0]);
            }
        }
        
        return sb.toString();
    }
    
    public int getIdx(char ch){
        if(ch == 'A' || ch == 'N')
            return 3;
        else if(ch == 'J' || ch == 'M')
            return 2;
        else if(ch == 'C' || ch == 'F')
            return 1;
        else
            return 0;
    }
}