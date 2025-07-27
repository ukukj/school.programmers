package LV2;

import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char before = words[0].charAt(0);
        Map<String, Integer> map = new HashMap<>();
        int num = 1;    // 번호
        int when = 1;   // 차례
        for (int i=0; i< words.length; i++) {
            // 뒷글자로 시작안하면
            if (before != words[i].charAt(0)) {
                answer[0] = num;
                answer[1] = when;
                break;
            }
            // 중복 단어면
            else if (map.containsKey(words[i])) {
                answer[0] = num;
                answer[1] = when;
                break;
            } else {
                if (num % n == 0) {
                    num = 1;
                    when ++;
                } else {
                    num ++;
                }
                map.put(words[i], 1);
                before = words[i].charAt(words[i].length()-1);
            }

        }

        return answer;
    }
}
