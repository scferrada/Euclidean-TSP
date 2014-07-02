package cc4102.app;

import cc4102.EuclideanTSPResolver;
import cc4102.convexhull.ConvexHullAlgorithm;
import cc4102.convexhull.ConvexHullResolver;
import cc4102.convexhull.FastConvexHull;
import cc4102.parser.InputParser;
import cc4102.util.TSPPoint;
import cc4102.util.hamiltonian.HamiltonianCircuit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 01-07-14
 * Time: 05:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class CHTest {
    static public void main(String[] args) throws IOException {
        EuclideanTSPResolver resolver = new ConvexHullResolver();
        List<TSPPoint> points = InputParser.parseFile("input/djibouti.txt");
        HamiltonianCircuit circuit = resolver.resolveTSP(points);
        System.out.println(circuit.length() + " circ, " + points.size() + " points");
        System.out.println("Total distance: "+circuit.distance());
    }

    static public void main2(String[] args){
        List<TSPPoint> points = new ArrayList<>();
        TSPPoint p1 = new TSPPoint(1,2),
                 p2 = new TSPPoint(1,1),
                 p3 = new TSPPoint(2,1.5),
                 p4 = new TSPPoint(3,2),
                 p5 = new TSPPoint(3,1),
                 p6 = new TSPPoint(2.5,1.5);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
        points.add(p6);
        ConvexHullAlgorithm algorithm = new FastConvexHull();
        List<TSPPoint> ch = algorithm.execute((ArrayList<TSPPoint>) points);
        System.out.println(ch);
        HamiltonianCircuit circuit = new ConvexHullResolver().resolveTSP(points);
        System.out.println(circuit.length() + " circ, " + points.size() + " points");
        System.out.println("Total distance: "+circuit.distance());
        circuit.print();
        double dist = p2.distance(p1) + p1.distance(p3) + p3.distance(p6) + p6.distance(p4) + p4.distance(p5) + p5.distance(p2);
        System.out.println("optimal distance: "+dist);
    }
}
