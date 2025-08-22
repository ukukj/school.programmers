package LV2;

import java.util.Deque;
import java.util.LinkedList;

public class 일차캐시 {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;

        Deque<String> cache = new LinkedList<>();
        int time = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            // cache hit
            if (cache.remove(city)) {
                time += 1;
            }
            // cache miss
            else {
                if (cache.size() == cacheSize) {
                    cache.pollFirst();
                }
                time += 5;
            }
            cache.addLast(city);
        }
        return time;
    }
}
