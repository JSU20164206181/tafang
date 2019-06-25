package youxi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import youxi.Map;

/**
 * A*�㷨---�Թ���Ѱ�����·��
 * 
 * @author fh
 *
 */
public class Xianlu {
    private static int[][] map = null;
    private static List<Node> openList = new ArrayList<Node>();// �����б�
    private static List<Node> closeList = new ArrayList<Node>();// �ر��б�
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
     // 0����ͨ·
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
     * ��Ѱ���·��
     * 
     * @param arr
     * @param startPoint
     * @param endPoint
     */
    private static boolean seachWay(int[][] arr, Node startPoint,
            Node endPoint, int row, int col) {
        final int CONST_HENG = 10;// ��ֱ�����ˮƽ�����ƶ���·������
       
        Node curNode = startPoint;
        if (startPoint.x < 0 || startPoint.y > col || endPoint.x < 0
                || endPoint.y > col || arr[startPoint.x][startPoint.y] == 0
                || arr[endPoint.x][endPoint.y] == 0) {
            throw new IllegalArgumentException("����������󣡣�");
        }

        openList.add(startPoint);
        while (!openList.isEmpty() && !openList.contains(endPoint)) {
            curNode = minList(openList);
            if (curNode.x == endPoint.x && curNode.y == endPoint.y
                    || openList.contains(endPoint)) {
                //System.out.println("�ҵ����·��");
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
            // ��
            if (curNode.y - 1 >= 0) {
                checkPath(curNode.x, curNode.y - 1, curNode, endPoint,
                        CONST_HENG);
            }
            // ��
            if (curNode.y + 1 < col) {
                checkPath(curNode.x, curNode.y + 1, curNode, endPoint,
                        CONST_HENG);
            }
            // ��
            if (curNode.x - 1 >= 0) {
                checkPath(curNode.x - 1, curNode.y, curNode, endPoint,
                        CONST_HENG);
            }
            // ��
            if (curNode.x + 1 < row) {
                checkPath(curNode.x + 1, curNode.y, curNode, endPoint,
                        CONST_HENG);
            }
         
            openList.remove(curNode);
            closeList.add(curNode);
        }
         if (!openList.contains(endPoint)) {
         System.out.println("һ��·����δ�ҵ�������");
         return false;
         }

        return false;

    }

    // �����㷨---���ڵ��Ƿ�ͨ·
    private static boolean checkPath(int x, int y, Node preNode, Node endPoint,
            int c) {
        Node node = new Xianlu().new Node(x, y, preNode);
        // ���ҵ�ͼ���Ƿ���ͨ��
        if (map[x][y] ==1||map[x][y] ==2||map[x][y] ==3||map[x][y] ==4) {
            closeList.add(node);
            return false;
        }
        // ���ҹر��б����Ƿ����
        if (isListContains(closeList, x, y) != -1) {// ����
            return false;
        }
        // ���ҿ����б����Ƿ����
        int index = -1;
        if ((index = isListContains(openList, x, y)) != -1) {// ����
            // Gֵ�Ƿ��С�����Ƿ����G��Fֵ
            if ((preNode.g + c) < openList.get(index).g) {
                countG(node, endPoint, c);
                countF(node);
                openList.set(index, node);
            }
        } else {
            // �����ڣ���ӵ������б���
            node.setParentNode(preNode);
            count(node, endPoint, c);
            openList.add(node);
        }
        return true;
    }

    // ����G,H,Fֵ
    private static void count(Node node, Node eNode, int cost) {
        countG(node, eNode, cost);
        countH(node, eNode);
        countF(node);
    }

    // ����Gֵ
    private static void countG(Node node, Node eNode, int cost) {
        if (node.getParentNode() == null) {
            node.setG(cost);
        } else {
            node.setG(node.getParentNode().getG() + cost);
        }
    }

    // ����Hֵ
    private static void countH(Node node, Node eNode) {
        node.setF((Math.abs(node.getX() - eNode.getX()) + Math.abs(node.getY()
                - eNode.getY())) * 10);
    }

    // ����Fֵ
    private static void countF(Node node) {
        node.setF(node.getG() + node.getH());
    }

    // �������Ƿ����ĳ��Ԫ��(-1��û���ҵ������򷵻����ڵ�����)
    private static int isListContains(List<Node> list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.getX() == x && node.getY() == y) {
                return i;
            }
        }
        return -1;
    }

    // ����Сֵ
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

    // �ڵ���
    private class Node {
        private int x;// X����
        private int y;// Y����
        private Node parentNode;// ����ڵ�
        private int g;// ��ǰ�㵽�����ƶ��ķ�
        private int h;// ��ǰ�㵽�յ���ƶ��ķѣ��������پ���|x1-x2|+|y1-y2|(�����ϰ���)
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

    // �ڵ�Ƚ���
    class NodeFComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getF() - o2.getF();
        }

    }

}