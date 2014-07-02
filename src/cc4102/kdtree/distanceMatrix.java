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
    double[] dm3;
    double [][] dm ;
    List<List<Double>>dm2;

    public distanceMatrix(TSPPoint [] points){
        int n = points.length;
        dm3 = new double[(n*(n+1))/2];
        for(int j = 0; j<n;j++){
            for(int i = 0; i<=j;i++){
               dm3[((2*n*i +i - i*i)/2)+(j-i)] = points[i].distance(points[j]);
            }
        }

    }

    public distanceMatrix(TSPPoint [] points, List<List<Double>>a){
        dm2 = a;
        for(int i = 0; i<points.length;i++){
            for(int j = 0; j<=i;j++){
                double dist = points[i].distance(points[j]);
                a.get(i).set(j,dist);
                a.get(j).set(i,dist);

            }
        }

    }

    public double [] getDm(){
        return dm3;
    }

    public List<List<Double>> getDM2(){
        return dm2;
    }
}