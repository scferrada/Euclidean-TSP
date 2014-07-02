package cc4102.app;

import cc4102.EuclideanTSPResolver;
import cc4102.convexhull.ConvexHullResolver;
import cc4102.kdtree.ClosestNeighborResolver;
import cc4102.parser.InputParser;
import cc4102.util.TSPPoint;
import cc4102.util.hamiltonian.HamiltonianCircuit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 01-07-14
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Experiment {
    static private Map<String, Double> countries = new HashMap<>();
    static {
        countries.put("canada", 1290319.0);
        countries.put("djibouti", 6656.0);
        countries.put("finland", 520527.0);
        countries.put("greece", 300899.0);
        countries.put("italy", 557315.0);
        countries.put("japan", 491924.0);
        countries.put("oman", 86891.0);
        countries.put("qatar", 9352.0);
        countries.put("sweden", 855597.0);
        countries.put("uruguay", 79114.0);
        countries.put("vietnam", 569288.0);
        countries.put("western sahara", 27603.0);
        countries.put("zimbabwe", 95345.0);
    }

    static private PrintWriter pw;

    static {
        try {
            pw = new PrintWriter("results.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static public void main(String args[]) throws IOException {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String, Double> e : countries.entrySet()){
            builder.append(e.getKey()).append(";").append(e.getValue()).append(";");

            List<TSPPoint> points = InputParser.parseFile("input/"+e.getKey()+".txt");
            EuclideanTSPResolver resolver = new ConvexHullResolver();
            long start = System.nanoTime();
            HamiltonianCircuit circuit = resolver.resolveTSP(points);
            long end = System.nanoTime();
            double d = circuit.distance();
            builder.append(end-start).append(";").append(d).append(";")
                    .append(d/e.getValue()).append(";");

            points = InputParser.parseFile("input/"+e.getKey()+".txt");
            resolver = new ClosestNeighborResolver();
            start = System.nanoTime();
            circuit = resolver.resolveTSP(points);
            end = System.nanoTime();
            d = circuit.distance();
            builder.append(end-start).append(";").append(d).append(";")
                    .append(d/e.getValue()).append("\n");
        }
        pw.write(builder.toString());
        pw.close();
    }
}
