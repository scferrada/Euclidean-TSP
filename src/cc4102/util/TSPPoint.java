package cc4102.util;

import cc4102.kdtree.tree.Axis;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TSPPoint {

        private double x;
        private double y;

        public TSPPoint(){
            x = y = 0.0;
        }

        public TSPPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double distance (TSPPoint that){
            return Math.sqrt(Math.pow(this.x - that.x,2) + Math.pow(this.y - that.y,2) );
        }

        @Override
        public String toString() {
            return x +","+ y;
        }

        public TSPPoint scaleBy(double v) {
            return new TSPPoint(x*v,y*v);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSPPoint tspPoint = (TSPPoint) o;

        if (Double.compare(tspPoint.x, x) != 0) return false;
        if (Double.compare(tspPoint.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getCoord(Axis axis) {
        switch (axis){
            case X:
                return x;
            case Y:
                return y;
            default:
                return 0.0;
        }
    }
}
