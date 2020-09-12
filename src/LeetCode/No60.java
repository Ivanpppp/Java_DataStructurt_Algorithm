package LeetCode;

import java.util.Arrays;

/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No60 {
    public static void main(String[] args) {

    }
    private static boolean[] vis; //用于判定是否被使用过
    private static int[] factorial; //阶乘数组
    public static String getPermutation(int n, int k) {
        // 计算数组的阶乘
        factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n ; i++) {
            factorial[i] = factorial[i-1]*i;
        }
        vis = new boolean[n+1];
        Arrays.fill(vis,false);
        StringBuffer path = new StringBuffer();
        dfs(n,k,0,path);
        return path.toString();
    }
    public static void dfs(int n,int k,int index,StringBuffer stringBuffer){
        if (index == n){
            return;
        }
        int cnt = factorial[n-1-index]; //判断未确定的数字的全排列个数
        for (int i = 1; i <= n ; i++) {
            if (vis[i]){
                continue;
            }
            if (cnt < k){

            }
        }
    }
}


































