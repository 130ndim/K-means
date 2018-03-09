/**
 * Created by dmitry on 07.03.2018.
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Scanner;

public class CSVReader {

    private ArrayList<Point> points = new ArrayList<>();

    public ArrayList<Point> CSVReader(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            Scanner scanner = null;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                Point p = new Point(Double.parseDouble(data[0]), Double.parseDouble(data[1]));
                points.add(p);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return points;
    }
}
