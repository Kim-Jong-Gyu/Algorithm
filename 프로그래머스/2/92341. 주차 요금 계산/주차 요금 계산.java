import java.util.*;

class Solution {
    
    public static int[] solution(int[] fees, String[] records) {
        Map<String, ArrayList<String>> cars = new TreeMap<>();
        
        
        for(int i = 0; i < records.length; i++){
            String[] splitFee = records[i].split(" ");
            ArrayList<String> tmp = cars.getOrDefault(splitFee[1], new ArrayList<String>());
            tmp.add(splitFee[0]);
            cars.put(splitFee[1], tmp);
        }
        // return value
        int[] ret = new int[cars.size()];
        int num = 0;
        for(String key : cars.keySet()){
            ArrayList<String> li = cars.get(key);
            int totalTime = calTime(li);
            ret[num] = calFees(totalTime, fees);
            num++;
        }
        return ret;
    }
    
    private static int calFees(int time, int[] fees){
        int defaultFee = fees[1];
        int extraTime = time - fees[0];
        if(extraTime <= 0)
            return defaultFee;
        int extraFee = (int)Math.ceil((double) extraTime / (double) fees[2]) * fees[3];
        return defaultFee + extraFee;
    }
    
    // 개수가 홀수다 -> 나간 시간이 없다 즉, 23:59를 추가 
    private static int calTime(ArrayList<String> time){
        int ret = 0;
        if((time.size() % 2) != 0){
            time.add("23:59");
        }
        for(int i = 1; i < time.size(); i+=2) {
            ret += (timeToInt(time.get(i)) - timeToInt(time.get(i - 1)));
        }
        return ret;
    }
    
    private static int timeToInt(String time){
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]) * 60;
        int minute = Integer.parseInt(splitTime[1]);
        return hour + minute;
    }
}