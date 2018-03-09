import java.util.ArrayList;

/**
 * Created by dmitry on 09.03.2018.
 */
public class KMeans {
    private static int numberOfClusters;
    private static int iterations;
    public static Cluster[] clusters;
    private static ArrayList<Point> points;

    public static Point[] kmeans(ArrayList<Point> data, int k, int iter, ArrayList<Point> seeds) {
        points = data;
        numberOfClusters = k;
        iterations = iter;
        clusters = new Cluster[numberOfClusters];
        Point[] centroids = new Point[numberOfClusters];

        for(int i = 0; i < numberOfClusters; i++) {
            clusters[i] = new Cluster(seeds.get(i));
        }

        for(int i = 0; i < iterations; i++) {
            ClusterPoints();
        }


        for(int i = 0; i < numberOfClusters; i++) {
            centroids[i] = clusters[i].GetCentroid();
        }

        return centroids;
    }

    private static int getClosestCentroid(Point chosenPoint) {
        int index = 0;
        double min = Distance.Euclidean(chosenPoint, clusters[index].GetCentroid());
        for(int i = 1; i < numberOfClusters; i++) {
            if(Distance.Euclidean(chosenPoint, clusters[i].GetCentroid()) < min) {
                min = Distance.Euclidean(chosenPoint, clusters[i].GetCentroid());
                index = i;
            }
        }
        return index;
    }

    private static void ClusterPoints() {

        for(int i = 0; i < numberOfClusters; i++) {
            clusters[i].ClearPoints();
        }

        for(Point point: points) {
            clusters[getClosestCentroid(point)].InsertPoint(point);
        }

        for(int i = 0; i < numberOfClusters; i++) {
            clusters[i].CalculateCentroid();
        }



    }

    public Cluster[] GetCLusters() {
        return clusters;
    }



}
