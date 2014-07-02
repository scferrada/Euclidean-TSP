package cc4102.kdtree;

import cc4102.util.TSPPoint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Claud
 * Date: 02-07-14
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class distanceMatrix {
    double [][] dm ;
    public distanceMatrix(TSPPoint [] points){
        dm = new double[points.length][points.length];
        for(int i = 0; i<points.length;i++){
            for(int j = 0; j<=i;j++){
                dm[i][j] = dm[j][i] = points[i].distance(points[j]);
            }
        }

    }

    public double [][] getDm(){
        return dm;
    }

}