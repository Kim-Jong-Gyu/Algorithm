class Solution {
    
    public char change(char before, int n, int standard){
        char after;
        if((int)before + n > standard)
            after = (char)((int)before + n - 26);
        else 
            after = (char)((int)before + n);
        return after;
    }
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == ' ')
                continue;
            if(Character.isUpperCase(charArr[i])){
                charArr[i] = change(charArr[i], n, 90);
            }
            else{
                charArr[i] = change(charArr[i], n, 122);
            }
        }
        return String.valueOf(charArr);
    }
}