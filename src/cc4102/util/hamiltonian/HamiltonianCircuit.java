package cc4102.util.hamiltonian;

import cc4102.util.TSPPoint;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-06-14
 * Time: 08:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class HamiltonianCircuit {
    private HVertex start;
    private HVertex end;

    public HamiltonianCircuit(TSPPoint tspPoint) {
        start = new HVertex(tspPoint);
    }
}
