package LV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
    public String[] solution(String[] files) {
        // 숫자 반영한 정렬 하도록, 단순 문자열 정렬 x
        // head, number, tail
        // head 사전순 정렬 (대소문자 구분 x)
        // head가 같을 경우 number순 정렬, (9 < 10 < 0011, 앞 0은 무시)
        // head, number 같은 경우 입력 순서 유지
        // 일단 자르자 head, number, tail로
        List<FileInfo> list = new ArrayList<>();

        for (String file: files) {
            list.add(parseFile(file));
        }
        Collections.sort(list, (f1, f2) -> {
            int headCompare = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }
            return Integer.compare(f1.number, f2.number);
        });

        String[] answer = new String[files.length];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).original;
        }
        return answer;
    }

    private FileInfo parseFile(String file) {
        // head
        int idx = 0;
        StringBuilder head = new StringBuilder();
        while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
            head.append(file.charAt(idx));
            idx ++;
        }

        // number
        StringBuilder number = new StringBuilder();
        while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
            number.append(file.charAt(idx));
            idx ++;
        }

        // tail
        StringBuilder tail = new StringBuilder();
        while (idx < file.length()) {
            tail.append(file.charAt(idx));
            idx ++;
        }

        return new FileInfo(head.toString(), Integer.parseInt(number.toString()), file);
    }
}

class FileInfo {
    String head;
    int number;
    String original;

    public FileInfo(String head, int number, String original) {
        this.head = head;
        this.number = number;
        this.original = original;
    }
}
