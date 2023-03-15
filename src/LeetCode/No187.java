package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No187 {
    public static void main(String[] args) {

    }

    /**
     * DNA序列由一系列核苷酸组成，缩写为'A','C','G'和'T'.。
     * 例如，"ACGAATTCCG"是一个 DNA序列 。
     * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
     * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的长度为10的序列(子字符串)。你可以按 任意顺序 返回答案。
     * 示例 1：
     * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出：["AAAAACCCCC","CCCCCAAAAA"]
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10;
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - L; i++) {
            String cur = s.substring(i, i + L);
            map.put(cur,map.getOrDefault(cur,0)+1);
            if (map.get(cur) == 2){
                ans.add(cur);
            }
        }
        return ans;
    }
}
