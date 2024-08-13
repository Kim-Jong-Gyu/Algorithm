import java.util.*;

class Solution {
    public int contain(String target, HashMap<String, Integer> players) {
        return players.get(target);
    }

    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            int idx = contain(callings[i], map);
            if (idx != 0){
                String tmp = players[idx - 1];
                players[idx - 1] = players[idx];
                map.put(players[idx], idx - 1);
                players[idx] = tmp;
                map.put(tmp , idx);
            }
        }
        return players;
    }
}