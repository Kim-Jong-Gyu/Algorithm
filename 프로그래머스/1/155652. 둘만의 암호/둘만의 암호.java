class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int cnt = 0;
            int now = s.charAt(i);
            while(cnt < index){
                now += 1;
                if(now > 122)
                    now = now - 26;
                if(skip.indexOf(now) != -1){
                    continue;
                }
                cnt += 1;
            }
            str.append((char)now);
        }
        return str.toString();
    }
    
    public boolean checkContain(String str, char c){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c)
                return true;
        }
        return false;
    }
}