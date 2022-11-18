//https://leetcode.com/problems/rectangle-area/

public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = 0;
        int areaofrec1 = Math.abs(ax1-ax2) * Math.abs(ay1 - ay2);
        int areaofrec2 = Math.abs(bx1-bx2) * Math.abs(by1-by2);
        int commonarea = 0;
        int xoverlap = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        int yoverlap = Math.min(by2,ay2) - Math.max(by1,ay1);

        if(xoverlap > 0 && yoverlap > 0){
            commonarea = Math.abs(xoverlap * yoverlap);
        }

        area = areaofrec1 + areaofrec2 - commonarea;
        return area;
    }
}
