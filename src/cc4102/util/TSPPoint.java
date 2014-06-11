package cc4102.util;

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
}
