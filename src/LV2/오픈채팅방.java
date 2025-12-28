package LV2;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        // ["a", "in"]
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String rec : record) {
            String[] parts = rec.split(" ");
            String act = parts[0];
            if (!act.equals("Leave")) {
                String id = parts[1];
                String name = parts[2];
                map.put(id, name);
            }
        }
        for (String rec: record) {
            StringBuilder sb = new StringBuilder();
            String[] parts = rec.split(" ");
            String act = parts[0];
            String id = parts[1];
            if (act.equals("Enter")) {
                sb.append(map.get(id));
                sb.append("님이 들어왔습니다.");
                list.add(sb.toString());
            }
            else if (act.equals("Leave")) {
                sb.append(map.get(id));
                sb.append("님이 나갔습니다.");
                list.add(sb.toString());
            }
        }
        String[] answer = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
