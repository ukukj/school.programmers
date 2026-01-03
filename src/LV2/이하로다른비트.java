package LV2;

public class 이하로다른비트 {
    public long[] solution(long[] numbers) {
        // f(1) = 2, f(2) = 3, f(3) = 5, f(4) = 5
        long[] answer = new long[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            long num = numbers[i];
            // 짝수
            if ((num&1) == 0) {
                answer[i] = num+1;
            } else {
                long y = num + 1;
                answer[i] = y + ((num ^ y) >> 2);
            }
        }
        return answer;
    }
}
