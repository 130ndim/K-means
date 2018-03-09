import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        ArrayList<Point> points = csvReader.CSVReader("/Users/dmitry/Desktop/KMeansImplementation/data/mask_7.csv");
        for(Point point : points) {
            System.out.print(point.x + " " + point.y + "\n");

        }
        int k = 3;
        int iter = 20;
        RandomSeed random = new RandomSeed();
        ArrayList<Point> seeds = random.GetPoints(k);

        Frame frame = new Frame();
        Graphics g = frame.panel.getGraphics();
        Drawer d = new Drawer();

        Point[] centroids = KMeans.kmeans(points, k, iter, seeds);
        Cluster[] clusters = KMeans.clusters;

        for(int i = 0; i < k; i++) {
            d.paintCentroid(g, centroids[i]);
            for(int j = 1; j < clusters[i].GetSize(); j++) {
                Point p = clusters[i].points.get(j);
                d.paint(g, p, i+1);
            }
        }
    }
}
