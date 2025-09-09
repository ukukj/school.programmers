package LV2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    public int solution(String word) {
        int answer = 0;
        int[] weights = new int[5];
        weights[0] = (int) (Math.pow(5,4) + Math.pow(5,3) + Math.pow(5,2) + Math.pow(5,1) + Math.pow(5,0));
        weights[1] = (int) (Math.pow(5,3) + Math.pow(5,2) + Math.pow(5,1) + Math.pow(5,0));
        weights[2] = (int) (Math.pow(5,2) + Math.pow(5,1) + Math.pow(5,0));
        weights[3] = (int) (Math.pow(5,1) + Math.pow(5,0));
        weights[4] = (int) (Math.pow(5,0));

        for (int i=0; i<word.length(); i++) {
            char x = word.charAt(i);
            int idx = "AEIOU".indexOf(x);
            answer += weights[i] * idx + 1;
        }
        return answer;
    }
}
