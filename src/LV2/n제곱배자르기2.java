package LV2;

public class n제곱배자르기2 {
    public int[] solution(int n, long left, long right) {
        int length = (int) (right - left + 1);
        int[] answer = new int[length];

        for (int i=0; i<length; i++) {
            long idx = left + i;
            int row = (int)(idx/n);
            int col = (int)(idx%n);
            answer[i] = Math.max(row, col) + 1;
        }
        return answer;
    }
}
