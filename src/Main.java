import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader();
        ArrayList<Point> points = csvReader.CSVReader("data/mask_7.csv"); // dataset path
        int k = 3;
        int iter = 20;
        RandomSeed random = new RandomSeed();
        ArrayList<Point> seeds = random.GetPoints(k);;

        Drawer d = new Drawer();

        BufferedImage bufferedImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, 600, 600);

        Point[] centroids = KMeans.kmeans(points, k, iter, seeds);
        Cluster[] clusters = KMeans.clusters;

        for(int i = 0; i < k; i++) {
            d.paintCentroid(g, centroids[i]);
            for(int j = 1; j < clusters[i].GetSize(); j++) {
                Point p = clusters[i].points.get(j);
                d.paint(g, p, i+1);
            }
        }

        g.dispose();

        File file = new File("output/mask_7.png"); // output path
        ImageIO.write(bufferedImage, "png", file);

    }
}
