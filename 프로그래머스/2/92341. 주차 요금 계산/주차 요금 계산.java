import java.util.*;

class Solution {
    private static Map<String, Integer> parseMap;
    public static void calTime(String in, String out, String num) {
        String[] aArr = in.split(":");
        String[] bArr = out.split(":");
        int inMin = Integer.parseInt(aArr[0]) * 60 + Integer.parseInt(aArr[1]);
        int outMin = Integer.parseInt(bArr[0]) * 60 + Integer.parseInt(bArr[1]);
        int dif = outMin - inMin;
        parseMap.put(num, parseMap.getOrDefault(num, 0) + dif);
    }

    public static void calFee(int[] fees) {
        for (String key : parseMap.keySet()) {
            if (parseMap.get(key) < fees[0]) {
                parseMap.put(key, fees[1]);
            } else {
                double addTime = parseMap.get(key) - fees[0];
                addTime = Math.ceil(addTime / fees[2]);
                int result = (int) (addTime * fees[3] + fees[1]);
                parseMap.put(key, result);
            }
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        parseMap = new TreeMap<>();
        List<Integer> answer = new ArrayList<>();
        Map<String, String> inMap = new HashMap<>();
        for (String record : records) {
            String[] splitRecords = record.split(" ");
            if (splitRecords[2].equals("IN")) {
                inMap.put(splitRecords[1], splitRecords[0]);
            } else {
                calTime(inMap.get(splitRecords[1]), splitRecords[0], splitRecords[1]);
                inMap.remove(splitRecords[1]);
            }
        }
        if (!inMap.isEmpty()) {
            for (String key : inMap.keySet()) {
                calTime(inMap.get(key), "23:59", key);
            }
        }
        calFee(fees);
        for (String key : parseMap.keySet()) {
            answer.add(parseMap.get(key));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}