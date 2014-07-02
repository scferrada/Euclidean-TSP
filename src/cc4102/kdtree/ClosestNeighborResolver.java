package cc4102.kdtree;

import cc4102.EuclideanTSPResolver;
import cc4102.util.hamiltonian.HVertex;
import cc4102.util.hamiltonian.HamiltonianCircuit;
import cc4102.util.TSPPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestNeighborResolver implements EuclideanTSPResolver{

    @Override
    public HamiltonianCircuit resolveTSP(List<TSPPoint> points) {

        //List<TSPPoint> leftovers = new ArrayList<TSPPoint>(points);
        //TSPPoint [] a = leftovers.toArray(new TSPPoint[0]);
        List<Integer> visitedPoints = new ArrayList<>();
        List<Integer> porVisitar = new ArrayList<>();
        //List<List<Double>> d = new ArrayList<>();
        //List<Double> auxd = new ArrayList<>();
        for(int i = 0; i<points.size(); i++){
            porVisitar.add(i);
            //auxd.add(0.0);
        }
        //for(int i = 0; i<points.size(); i++){
          //  d.add(new ArrayList<Double>(auxd));
        //}
        //System.out.println("calculando matrix");
        //distanceMatrix dist = new distanceMatrix(a,d);
        //d=dist.getDM2();
        //System.out.println("eeee");

        int rand = (int) (Math.random()*(points.size()-1));
        HamiltonianCircuit hc = new HamiltonianCircuit();
        visitedPoints.add(rand);
        int dPoint = rand;
        porVisitar.remove((Object) rand);
        hc.appendVertex(new HVertex(points.get(rand)));
        Map<Point, Double> matrix = new HashMap<Point, Double>();


        while (porVisitar.size()>0){
            double min = Double.POSITIVE_INFINITY;
            int indexmnin=-1;

            for(int j:porVisitar){
                matrix.put(new Point(dPoint,j),points.get(dPoint).distance(points.get(j)));
            }
            for(int i: visitedPoints){
                for(int j: porVisitar){
                    double candmin=matrix.get(new Point(i, j));

                    if(candmin<min){
                        min=candmin;
                        indexmnin=j;
                    }
                }
            }
            visitedPoints.add(indexmnin);
            porVisitar.remove((Object) indexmnin);
            dPoint=indexmnin;
            hc.appendVertex(new HVertex(points.get(indexmnin)));


        }

        return hc;
    }
}