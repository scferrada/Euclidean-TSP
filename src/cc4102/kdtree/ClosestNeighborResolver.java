package cc4102.kdtree;

import cc4102.EuclideanTSPResolver;
import cc4102.util.hamiltonian.HVertex;
import cc4102.util.hamiltonian.HamiltonianCircuit;
import cc4102.util.TSPPoint;

import java.util.List;

public class ClosestNeighborResolver implements EuclideanTSPResolver{

    @Override
    public HamiltonianCircuit resolveTSP(List<TSPPoint> points) {

        List<TSPPoint> leftovers = points;
        int rand = (int) Math.random()*(leftovers.size()-1);
        HamiltonianCircuit hc = new HamiltonianCircuit(leftovers.get(rand));
        leftovers.remove(rand);

        while (leftovers.size()>0){
            double min = Double.POSITIVE_INFINITY;
            HVertex minHc= null;
            TSPPoint p = null;
            int indexp = -1;

            for(TSPPoint cand: leftovers){
                minHc = hc.calcMinDistance(cand);
                double minp = cand.distance(minHc.getPoint());
                if (minp<min){
                    min=minp;
                    p=cand;
                    indexp=leftovers.indexOf(cand);
                }
            }

            leftovers.remove(indexp);
            hc.addPointAfter(p,minHc);

        }

        return hc;  //To change body of implemented methods use File | Settings | File Templates.
    }
}