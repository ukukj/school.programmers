package LV2;

import java.util.Stack;

public class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i=0; i< answer.length; i++) {
            answer[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<numbers.length; i++) {
            int x = numbers[i];
            if (!stack.isEmpty()) {
                int idx = stack.peek();
                while (x > numbers[idx]) {
                    answer[idx] = x;
                    stack.pop();
                    if (stack.isEmpty()) break;
                    idx = stack.peek();
                }
            }
            stack.push(i);
        }
        // [0,2]에서 3들어옴
        // [0,2,3]에서 6들어옴
        // [0,4]
        return answer;
    }
}
