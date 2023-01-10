// https://leetcode.com/problems/max-points-on-a-line/

import java.util.*;

class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        HashMap<Line,HashSet<int[]>>map = new HashMap<>();
        int len = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                Line l = findLine(points[i][0], points[i][1], points[j][0], points[j][1]);
                map.putIfAbsent(l,new HashSet<>());
                map.get(l).add(points[i]);
                map.get(l).add(points[j]);
                len = Math.max(len, map.get(l).size());
                for (int[] ks : map.get(l)) {
                    System.out.println(ks[0]+" "+ks[1]);
                }
            }
        }
        return len;
    }

    Line findLine(int x0 ,int y0, int x1 , int y1){
        if (y0 == y1)
        return new Line(0, (float)y1);
        if(x0 == x1) return new Line(x1, null);
        float slope = (float)(y1-y0)/(float)(x1-x0);
        float intercept = y0 - slope*x0;
        return new Line(slope, intercept);
    }

    class Line{
        float slope;
        Float intercept;
        int hashCode;

        Line(float s, Float i) {
            slope = s;
            intercept = i;
            this.hashCode = Objects.hash(s, i);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Line that = (Line) o;
            return slope== that.slope && intercept == that.intercept;
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }
    }
}