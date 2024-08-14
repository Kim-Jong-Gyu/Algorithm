import java.util.*;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> userReportTo = new HashMap<>();
        Map<String, Set<String>> userReportFrom = new HashMap<>();
        Set<String> userStop = new HashSet<>();
        
        // user가 신고한 사람들의 집합
        for(int i = 0; i < report.length; i++){
            String[] splitReport = report[i].split(" ");
            if(userReportTo.get(splitReport[0]) == null){
                Set<String> toSet = new HashSet<>();
                toSet.add(splitReport[1]);
                userReportTo.put(splitReport[0], toSet); 
                    
            }
            else {
                userReportTo.get(splitReport[0]).add(splitReport[1]);
            }
        }
        
        // 신고 당한 사람들의 기준의 집합
        for(int i = 0; i < report.length; i++){
            String[] splitReport = report[i].split(" ");
            if(userReportFrom.get(splitReport[1]) == null){
                Set<String> fromSet = new HashSet<>();
                fromSet.add(splitReport[0]);
                userReportFrom.put(splitReport[1], fromSet); 
                    
            }
            else {
                userReportFrom.get(splitReport[1]).add(splitReport[0]);
            }
        }
        
        // 정지 당한 사람 
        for(String key : userReportFrom.keySet()){
            if(userReportFrom.get(key).size() >= k)
                userStop.add(key);
        }
        
        // 교집합을 이용 
        for(int i = 0; i < id_list.length; i++){
            if(userReportTo.get(id_list[i]) != null){
                userReportTo.get((id_list[i])).retainAll(userStop);
                answer[i] = userReportTo.get(id_list[i]).size();
            }
        }
        return answer;
    }
}