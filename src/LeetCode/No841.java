package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。

最初，除 0 号房间外的其余所有房间都被锁住。

你可以自由地在房间之间来回走动。

如果能进入每个房间返回 true，否则返回 false。

示例 1：

输入: [[1],[2],[3],[]]
输出: true
解释:
我们从 0 号房间开始，拿到钥匙 1。
之后我们去 1 号房间，拿到钥匙 2。
然后我们去 2 号房间，拿到钥匙 3。
最后我们去了 3 号房间。
由于我们能够进入每个房间，我们返回 true。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/keys-and-rooms
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No841 {
    int num;
    boolean[] vis;
    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // DFS对其进行遍历操作
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms,0);
        return num == n;
    }
    public  void dfs(List<List<Integer>> nums,int x){
        vis[x] = true;
        num+=1;
        for (int s :
                nums.get(x)) {
            if (!vis[s]){
                dfs(nums, s);
            }
        }
    }

    public void bfs(List<List<Integer>> nums){
        int n = nums.size();
        boolean[] ans = new boolean[n];
        int num = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        ans[0] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            num++;
            for (int x :
                    nums.get(cur)) {
                if (!ans[x]){
                    ans[x] = true;
                    queue.offer(x);
                }
            }
        }

    }
}
