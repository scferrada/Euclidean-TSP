package cc4102.kdtree;

import cc4102.EuclideanTSPResolver;
import cc4102.util.hamiltonian.HVertex;
import cc4102.util.hamiltonian.HamiltonianCircuit;
import cc4102.util.TSPPoint;

import java.util.ArrayList;
import java.util.List;

public class ClosestNeighborResolver implements EuclideanTSPResolver{

    @Override
    public HamiltonianCircuit resolveTSP(List<TSPPoint> points) {

        List<TSPPoint> leftovers = new ArrayList<TSPPoint>(points);
        TSPPoint [] a = leftovers.toArray(new TSPPoint[0]);
        List<Integer> visitedPoints = new ArrayList<>();
        List<Integer> porVisitar = new ArrayList<>();

        for(int i = 0; i<points.size(); i++){
            porVisitar.add(i);
        }

        distanceMatrix dist = new distanceMatrix(a);
        double[][]dm=dist.getDm();

        int rand = (int) (Math.random()*(a.length-1));
        HamiltonianCircuit hc = new HamiltonianCircuit();
        visitedPoints.add(rand);
        porVisitar.remove((Object) rand);
        hc.appendVertex(new HVertex(leftovers.get(rand)));



        while (porVisitar.size()>0){
            double min = Double.POSITIVE_INFINITY;
            int indexmnin=-1;
            for(int i: visitedPoints){
                for(int j: porVisitar){
                    double candmin= dm[i][j];
                    if(candmin<min){
                        min=candmin;
                        indexmnin=j;
                    }
                }
            }
            visitedPoints.add(indexmnin);
            porVisitar.remove((Object) indexmnin);
            hc.appendVertex(new HVertex(leftovers.get(indexmnin)));


        }

        return hc;
    }
}