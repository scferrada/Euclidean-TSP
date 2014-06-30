package cc4102.parser;

import cc4102.util.TSPPoint;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 29-06-14
 * Time: 09:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputParser {

    public List<TSPPoint> parseFile(String filename) throws IOException {
        List<TSPPoint> points = new ArrayList<TSPPoint>();
        BufferedReader file = new BufferedReader(new FileReader(filename));
        String line = file.readLine();
        while(line != null){
            if(Character.isDigit(line.charAt(0))){
                String [] parts = line.split(" ");
                points.add(new TSPPoint(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
            }
            line = file.readLine();
        }
        return points;
    }
}
