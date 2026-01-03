package LV2;

import java.util.Arrays;

public class 가장큰수 {
    public String solution(int[] numbers) {
        // 9, 55, 58, 53, 39, 531, 42, 2
        // a+b vs b+a
        // a+b가 더크면 a가 먼저
        // b+a가 더크면 b가 먼저
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        if (arr[0].equals("0")) return "0";
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
