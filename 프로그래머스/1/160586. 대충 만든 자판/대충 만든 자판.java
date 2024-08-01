import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < targets.length; i++){
            int tc = 0;
            boolean check = true;
            for(int j = 0; j < targets[i].length(); j++){
                int tmp = findIndex(keymap, targets[i].charAt(j));
                if(tmp == -1){
                    check = false;
                    break;
                }
                else {
                    tc += tmp;
                }
            }
            if(!check){
                list.add(-1);
            }
            else {
                list.add(tc);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int findIndex(String[] keymap, char c){
        int ret = 987654321;
        for(int i = 0; i < keymap.length; i++){
            int tmp = keymap[i].indexOf(c);
            if(tmp != -1){
                ret = Math.min(ret, tmp);
            }
        }
        if(ret == 987654321)
            return -1;
        return ret + 1;
    }
}