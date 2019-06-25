package youxi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import youxi.Map;

/**
 * A*算法---迷宫中寻找最短路径
 * 
 * @author fh
 *
 */
public class Xianlu {
    private static int[][] map = null;
    private static List<Node> openList = new ArrayList<Node>();// 开启列表
    private static List<Node> closeList = new ArrayList<Node>();// 关闭列表
    static int[ ] lx=new int[50];
    static int[ ] ly=new int[50];
     int l=0;
    static int[ ] lX=new int[50];
    static int[ ] lY=new int[50];
    public static void main(String[] args) {
      Xianlu.luxian();
    }

    
public static void luxian(){
	 int Max_row = 6;
     int MAX_col = 12;
     // 0代表通路
     map =Map.getMaplog();
     	
     Node startPoint = new Xianlu().new Node(3, 0, null);
     Node endPoint = new Xianlu().new Node(2,  11, null);
     

     seachWay(map, startPoint, endPoint, Max_row, MAX_col);
     int l = 0;
 for(int i=lx.length-1;i>=0;i--){
 	if(lx[i]==0&&ly[i]==0){continue;}
 	//System.out.print(i+"("+lx[i]+","+ly[i]+")");
 	lX[l]=lx[i];
 	lY[l]=ly[i];
 	 l++;
 	}

  for (int i = 0; i < Max_row; i++) {
 for (int j = 0; j < MAX_col; j++) {
 	
     System.out.print(map[i][j]+" ");
 }
 System.out.print("\n");
}
 for(int i=0;i<lX.length-1;i++){
	 	if(lX[i]==0&&lY[i]==0){continue;}
	 	l++;
		System.out.print(i+"("+lX[i]+","+lY[i]+")");}
 System.out.println();


} 
    
    

public static int[] getlX() {
	return lX;
}


public static int[] getlY() {
	return lY;
}


	/**
     * 搜寻最短路径
     * 
     * @param arr
     * @param startPoint
     * @param endPoint
     */
    private static boolean seachWay(int[][] arr, Node startPoint,
            Node endPoint, int row, int col) {
        final int CONST_HENG = 10;// 垂直方向或水平方向移动的路径评分
       
        Node curNode = startPoint;
        if (startPoint.x < 0 || startPoint.y > col || endPoint.x < 0
                || endPoint.y > col || arr[startPoint.x][startPoint.y] == 0
                || arr[endPoint.x][endPoint.y] == 0) {
            throw new IllegalArgumentException("坐标参数错误！！");
        }

        openList.add(startPoint);
        while (!openList.isEmpty() && !openList.contains(endPoint)) {
            curNode = minList(openList);
            if (curNode.x == endPoint.x && curNode.y == endPoint.y
                    || openList.contains(endPoint)) {
                //System.out.println("找到最短路径");
            	int i=0;
                while(!(curNode.x==startPoint.x&&curNode.y==startPoint.y)){
                	 
                 // System.out.print(i+"("+curNode.x+","+curNode.y+") ");
                    lx[i]=curNode.x;
                    ly[i]=curNode.y;
                    i++;
                  // map[curNode.x][curNode.y]=2;
                    if (curNode.parentNode!=null) {
                        curNode=curNode.parentNode;
                    }
                }
          //      System.out.print(i+"("+startPoint.x+","+startPoint.y+")\n ");
             // map[startPoint.x][startPoint.y]=2;
               lx[i+1]=curNode.x;
               ly[i+1]=curNode.y;
                return true;
            }
            // 上
            if (curNode.y - 1 >= 0) {
                checkPath(curNode.x, curNode.y - 1, curNode, endPoint,
                        CONST_HENG);
            }
            // 下
            if (curNode.y + 1 < col) {
                checkPath(curNode.x, curNode.y + 1, curNode, endPoint,
                        CONST_HENG);
            }
            // 左
            if (curNode.x - 1 >= 0) {
                checkPath(curNode.x - 1, curNode.y, curNode, endPoint,
                        CONST_HENG);
            }
            // 右
            if (curNode.x + 1 < row) {
                checkPath(curNode.x + 1, curNode.y, curNode, endPoint,
                        CONST_HENG);
            }
         
            openList.remove(curNode);
            closeList.add(curNode);
        }
         if (!openList.contains(endPoint)) {
         System.out.println("一条路径都未找到！！！");
         return false;
         }

        return false;

    }

    // 核心算法---检测节点是否通路
    private static boolean checkPath(int x, int y, Node preNode, Node endPoint,
            int c) {
        Node node = new Xianlu().new Node(x, y, preNode);
        // 查找地图中是否能通过
        if (map[x][y] ==1||map[x][y] ==2||map[x][y] ==3||map[x][y] ==4) {
            closeList.add(node);
            return false;
        }
        // 查找关闭列表中是否存在
        if (isListContains(closeList, x, y) != -1) {// 存在
            return false;
        }
        // 查找开启列表中是否存在
        int index = -1;
        if ((index = isListContains(openList, x, y)) != -1) {// 存在
            // G值是否更小，即是否更新G，F值
            if ((preNode.g + c) < openList.get(index).g) {
                countG(node, endPoint, c);
                countF(node);
                openList.set(index, node);
            }
        } else {
            // 不存在，添加到开启列表中
            node.setParentNode(preNode);
            count(node, endPoint, c);
            openList.add(node);
        }
        return true;
    }

    // 计算G,H,F值
    private static void count(Node node, Node eNode, int cost) {
        countG(node, eNode, cost);
        countH(node, eNode);
        countF(node);
    }

    // 计算G值
    private static void countG(Node node, Node eNode, int cost) {
        if (node.getParentNode() == null) {
            node.setG(cost);
        } else {
            node.setG(node.getParentNode().getG() + cost);
        }
    }

    // 计算H值
    private static void countH(Node node, Node eNode) {
        node.setF((Math.abs(node.getX() - eNode.getX()) + Math.abs(node.getY()
                - eNode.getY())) * 10);
    }

    // 计算F值
    private static void countF(Node node) {
        node.setF(node.getG() + node.getH());
    }

    // 集合中是否包含某个元素(-1：没有找到，否则返回所在的索引)
    private static int isListContains(List<Node> list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.getX() == x && node.getY() == y) {
                return i;
            }
        }
        return -1;
    }

    // 找最小值
    private static Node minList(List<Node> list) {
        Iterator<Node> i = list.iterator();
        Node candidate = i.next();

        while (i.hasNext()) {
            Node next = i.next();
            if (next.compareTo(candidate) < 0)
                candidate = next;
        }
        return candidate;
    }

    // 节点类
    private class Node {
        private int x;// X坐标
        private int y;// Y坐标
        private Node parentNode;// 父类节点
        private int g;// 当前点到起点的移动耗费
        private int h;// 当前点到终点的移动耗费，即曼哈顿距离|x1-x2|+|y1-y2|(忽略障碍物)
        private int f;// f=g+h

        public Node(int x, int y, Node parentNode) {
            this.x = x;
            this.y = y;
            this.parentNode = parentNode;
        }

        public int compareTo(Node candidate) {
            return this.getF() - candidate.getF();
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Node getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }

        public String toString() {
            return "(" + x + "," + y + "," + f + ")";
        }
    }

    // 节点比较类
    class NodeFComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getF() - o2.getF();
        }

    }

}