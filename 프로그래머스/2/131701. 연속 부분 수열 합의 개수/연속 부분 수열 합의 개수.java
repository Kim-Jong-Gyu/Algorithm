import java.util.*;

class Solution {
    
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
    
        for(int i = 0; i < elements.length; i++){
            List<Integer> newEl = makeCircle(elements, i);
            for(int j = 0; j < elements.length; j++){
                int sum = 0;
                sum = newEl.subList(j, j + i + 1)
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
                set.add(sum);
            }
        }
        return set.size();
    }
    
    public List<Integer> makeCircle(int[] elements, int n){
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < elements.length; i++){
            ret.add(elements[i]);
        }
        for(int i = 0; i < n; i++){
            ret.add(elements[i]);
        }
        return ret;
    }
}