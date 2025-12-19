package LV2;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime  = new HashMap<>();
        for (String record: records) {
            String time = record.split(" ")[0];
            String num  = record.split(" ")[1];
            String act  = record.split(" ")[2];

            int min = getMin(time);
            if (act.equals("IN")) {
                inTime.put(num, min);
            } else {
                int in = inTime.remove(num);
                totalTime.put(num, totalTime.getOrDefault(num, 0) + min - in);
            }
        }
        for (String num : inTime.keySet()) {
            int in = inTime.get(num);
            int min = getMin("23:59");
            totalTime.put(num, totalTime.getOrDefault(num, 0) + min - in);
        }
        int[] answer = new int[totalTime.size()];
        int cnt = 0;
        List<String> keys = new ArrayList<>(totalTime.keySet());
        keys.sort(Comparator.comparingInt(Integer::parseInt));
        for (String num: keys) {
            int money;
            if (totalTime.get(num) > fees[0]) {
                money = (int) (fees[1] + Math.ceil((totalTime.get(num) - fees[0]) / (double)fees[2]) * fees[3]);
            } else {
                money = fees[1];
            }
            answer[cnt] = money;
            cnt ++;
        }
        return answer;
    }

    private int getMin(String time) {
        String hour   = time.split(":")[0];
        String minute = time.split(":")[1];

        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }


}
