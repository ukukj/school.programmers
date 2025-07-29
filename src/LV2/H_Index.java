package LV2;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        while (true) {
            int up_cnt = 0;
            for (int i=0; i<citations.length; i++) {
                // h번 이상 인용 논문
                if (answer <= citations[i]) {
                    up_cnt ++;
                }
            }
            if (up_cnt >= answer) {
                answer ++;
            } else {
                answer --;
                break;
            }
        }
        return answer;
    }
}
