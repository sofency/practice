/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
import java.util.Scanner;//导入读写库
public class FindNearestPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numberOfPoints = input.nextInt();//读取点数
        //create an array to store points
        double[][] points = new double[numberOfPoints][2];
        System.out.print("Enter "+numberOfPoints+" points");
        for (int i = 0; i < points.length; i++) {
           points[i][0]=input.nextDouble();
           points[i][1]=input.nextDouble();
        }
        //assume the shortest distance is between the first point and the second point
        int p1=0,p2=1;
        double shortestDistance =distance(points[p1][0],points[p1][1],points[p2][0],points[p2][1]);
        //compute distance of every  two points
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double distance=distance(points[i][0],points[i][1],points[j][0],points[j][1]);
                if(shortestDistance>distance){
                    p1=i;
                    p2=j;
                    shortestDistance=distance;
                }
            }
        }
        System.out.println("The shortest distance is between ("+points[p1][0]+","+points[p1][1]+")and("+points[p2][0]+","+points[p2][1]+")");
    }
    public static double distance(double x1,double y1,double x2,double y2) {
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}
