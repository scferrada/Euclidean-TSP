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
        System.out.println(leftovers.size());
        int rand = (int) (Math.random()*(leftovers.size()-1));
        System.out.println("random" + rand);
        HamiltonianCircuit hc = new HamiltonianCircuit(leftovers.get(rand));
        System.out.println(leftovers.get(rand));
        System.out.println(hc.getFirst().getPoint());

        leftovers.remove(rand);
        System.out.println(leftovers.size());

        while (leftovers.size()>0){
            double min = Double.POSITIVE_INFINITY;
            HVertex minHc= null;
            TSPPoint p = null;
            int indexp = -1;

            for(TSPPoint cand: leftovers){
                minHc = hc.calcMinDistance(cand);

                double minp = cand.distance(minHc.getPoint());
                System.out.println(minp);
                if (minp<min){
                    min=minp;
                    p=cand;
                    indexp=leftovers.indexOf(cand);
                }
            }

            leftovers.remove(indexp);
            System.out.println(leftovers.size());
            hc.addPointAfter(p,minHc);

        }

        return hc;  //To change body of implemented methods use File | Settings | File Templates.
    }
}