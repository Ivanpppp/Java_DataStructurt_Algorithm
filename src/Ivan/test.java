package Ivan;

import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 10.3);
        map.put(2, 5.2);
        map.put(3, 6.7);
        map.put(4, 20.1);
        map.put(5, 1.1);
        map.put(6, 7.5);
        map.put(7, 8.6);
        map.put(8, 99.7);
        map.put(9, 50.66);


        System.out.println("Original...");
        System.out.println(map);

        //sort by values, and reserve it, 10,9,8,7,6...
        Map<Integer,Double> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue,newValue) -> oldValue,LinkedHashMap::new));
        System.out.printf(String.valueOf(result));
    }
}

