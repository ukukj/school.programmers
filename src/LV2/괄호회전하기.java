package LV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack stack = new Stack();
        for (int i=0; i<s.length(); i++) {
            boolean flag = true;
            for (int j=0; j<s.length(); j++) {
                int idx = i+j >= s.length() ? (i+j) - s.length() : i+j;
                char now = s.charAt(idx);
                if (map.containsKey(now)) {
                    stack.push(now);
                } else {
                    if (!stack.isEmpty() && map.get(stack.peek()).equals(now)) {
                        stack.pop();
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && stack.isEmpty()) answer++;
        }
        return answer;
    }
}
