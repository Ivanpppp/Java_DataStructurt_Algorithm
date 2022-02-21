package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class No2013 {
    Map<Integer,Map<Integer,Integer>> cnt;

    public No2013() {
        cnt = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        cnt.putIfAbsent(y,new HashMap<>());
    }

    public int count(int[] point) {

    }
}
