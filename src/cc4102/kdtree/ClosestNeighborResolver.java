package cc4102.kdtree;

import cc4102.EuclideanTSPResolver;
import cc4102.util.hamiltonian.HamiltonianCircuit;
import cc4102.util.TSPPoint;
import cc4102.kdtree.tree.*;

import java.util.LinkedList;
import java.util.List;

public class ClosestNeighborResolver implements EuclideanTSPResolver{

    @Override
    public HamiltonianCircuit resolveTSP(List<TSPPoint> points) {
        List<TSPPoint> circuit = new LinkedList<TSPPoint>();
        List<TSPPoint> leftovers = points;
        int rand = (int) Math.random()*leftovers.size();
        circuit.add(leftovers.get(rand));
        leftovers.remove(rand);

        while (leftovers.size()>0){
            double min = Double.MAX_VALUE;
            TSPPoint p = null;
            int indexp = -1;

            for(TSPPoint cand: leftovers){
                double minp = calcMin(cand,circuit);
                if (minp<min){
                    min=minp;
                    p=cand;
                    indexp=leftovers.indexOf(cand);
                }
            }

            leftovers.remove(indexp);
            TSPPoint near =

        }




        KDTree kdTree = KDTreeFactory.makeMedianTreeWith(points);
        HamiltonianCircuit C = new HamiltonianCircuit(points.get(0));

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}