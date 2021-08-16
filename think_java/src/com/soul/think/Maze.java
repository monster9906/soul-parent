package com.soul.think;

/**
 * @author LingCoder
 * @Description: 迷宫问题
 * @Date 2020/11/17-22:33
 */
public class Maze {
    private static int[][] map = new int[8][7];
    static {
        // 1-城墙 上下 左右填充城墙
        for (int i = 0; i < 7; i++) { // 上下
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {// 左右
            map[i][0] = 1;
            map[i][6] = 1;
        }
    }

    public static void main(String[] args) {
        // 随机设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("======================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @author LingCoder
     * @date 2020/11/17 22:50
     * @description: 如果能移动到map[6][5]的位置，即地图右下角 表示通过
     * map[i][j] 0 - 表示当前点未走过 1 -表示墙 2-表示当前点可以走 3-表示当前点已经走过 但是走不通
     * 走迷宫的策略 下>左>上>右
     * @param map 地图 ,i，j开始移动位置
     */
    public static boolean setWay(int[][] map ,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){ //当前点没有走过
                // 假定当前点是可以走的
                map[i][j] = 2;
                if(setWay(map,i+1,j)){ // 向下走
                    return true;
                }else if(setWay(map,i,j+1)){ // 向右走
                    return true;
                }else if(setWay(map,i-1,j)){ // 向上走
                    return true;
                }else if(setWay(map,i,j-1)){ //向右走
                    return true;
                }else { // 所有的情况都不能走通 上面当前点是死路
                    map[i][j] = 3;
                    return false;
                }
            }
            else { // 当前点是 1 2 3
                return false;
            }
        }
    }
}
