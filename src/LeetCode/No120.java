package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No120 {
    public static void main(String[] args) {

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle == null) return 0;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(triangle.get(0)));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curList = triangle.get(i);
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < curList.size(); j++) {
                int curNum = 0;
                if (j == 0) {
                    curNum = curList.get(j) + list.get(i - 1).get(0);
                    newList.add(curNum);
                } else if (j == curList.size() - 1) {
                    curNum = curList.get(j) + list.get(i - 1).get(list.get(i - 1).size() - 1);
                    newList.add(curNum);
                }else {
                    curNum = curList.get(j) + Math.min(list.get(i-1).get(j-1),list.get(i-1).get(j));
                    newList.add(curNum);
                }
                System.out.printf("  " + curNum);
            }
            list.add(newList);
            System.out.println();
        }
        int ans = Integer.MAX_VALUE;
        List<Integer> res = list.get(list.size() - 1);
        for (int i = 0; i < res.size(); i++) {
            ans = Math.min(ans,res.get(i));
        }

        return ans;
    }
}
