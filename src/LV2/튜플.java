package LV2;

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        List<List<Integer>> totalLIst = new ArrayList<>();
        s = s.substring(2, s.length()-2);
        String[] parts = s.split("\\},\\{");
        for (String part : parts) {
            String[] nums = part.split(",");
            List<Integer> list = new ArrayList<>();
            for (String num : nums) {
                list.add(Integer.parseInt(num));
            }
            totalLIst.add(list);
        }
        for (int i=0; i<totalLIst.size(); i++) {
            if (totalLIst.get(i).isEmpty()) {
                totalLIst.remove(i);
            }
        }

        // 길이로 정렬
        totalLIst.sort(Comparator.comparingInt(List::size));
        List<Integer> answerList = new ArrayList<>();
        for (int i=0; i<totalLIst.size(); i++) {
            List<Integer> list = totalLIst.get(i);
            for (int j=0; j<list.size(); j++) {
                if (!answerList.contains(list.get(j))) {
                    answerList.add(list.get(j));
                }
            }
        }

        // list to array
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
