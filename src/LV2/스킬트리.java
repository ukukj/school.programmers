package LV2;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i=0; i< skill_trees.length; i++) {
            String x = skill_trees[i];
            List<Integer> list = new ArrayList<>();
            for (char c : skill.toCharArray()) {
                int idx = x.indexOf(c);
                if (idx == -1) idx = Integer.MAX_VALUE;
                list.add(idx);
            }
            boolean flag = false;
            for (int j=0; j<list.size(); j++) {
                if (flag) break;
                for (int k=j; k<list.size(); k++) {
                    if (list.get(j) > list.get(k)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) answer ++;
        }
        return answer;
    }
}
