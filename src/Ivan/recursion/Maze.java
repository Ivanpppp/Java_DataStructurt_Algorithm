package Ivan.recursion;

public class Maze {
    public static void main(String[] args) {
        //二维数组创建迷宫
        int[][] map = new int[8][7];
        //1为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置路障
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        //使用递归给小球找路
        findWay(map, 1, 1);
        //输出小球走过的地图
        System.out.println("小球走过的路径");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @param map 地图
     * @param i   小球起始横坐标
     * @param j   小球起始纵坐标
     * @return 找到通路返回true，否则返回false
     */
    //设map[6][5]为终点
    //约定1为墙，2为通路，3为走过但走不通，0为没有走过
    public static boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;  //假定这点能走通
                if (findWay(map, i + 1, j)) {    //向下走
                    return true;
                } else if (findWay(map, i, j + 1)) {  //向下走
                    return true;
                } else if (findWay(map, i + 1, j)) {  //向左走
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] != 0
                return false;
            }
        }

    }
}
