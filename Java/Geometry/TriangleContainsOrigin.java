package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Three distinct points are plotted at random on a Cartesian plane, for which - 1000 ≤ x, y ≤ 1000, such that a triangle is formed.
// Consider the following two triangles:
// A(-340, 495), B(-153, -910), C (835, -947)
// X (-175,41), Y (-421, -714), Z(574, -645)
// It can be verified that triangle ABC contains the origin, whereas triangle XYZ does not.
// Using triangles.txt (right click and 'Save Link/Target As...'), a 27K text file containing the co-ordinates of one thousand "random" triangles, find the number of triangles for which the interior contains the origin.

public class TriangleContainsOrigin {

    public static void main(String[] args) throws FileNotFoundException {
        int count = 0;
        File file = new File("triangles.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] points = line.split(",");

            int x1 = Integer.parseInt(points[0]);
            int y1 = Integer.parseInt(points[1]);
            int x2 = Integer.parseInt(points[2]);
            int y2 = Integer.parseInt(points[3]);
            int x3 = Integer.parseInt(points[4]);
            int y3 = Integer.parseInt(points[5]);

            if (isPointInTriangle(0, 0, x1, y1, x2, y2, x3, y3)) {
                count++;
            }
        }

        scanner.close();
        System.out.println("Number of triangles containing the origin: " + count);
    }

    // checking if origin is on the same side for all edges
    static boolean isPointInTriangle(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3) {
        int sameSideAB = (x2 - x1) * (y - y1) - (y2 - y1) * (x - x1);
        int sameSideBC = (x3 - x2) * (y - y2) - (y3 - y2) * (x - x2);
        int sameSideCA = (x1 - x3) * (y - y3) - (y1 - y3) * (x - x3);
        return (sameSideAB >= 0 && sameSideBC >= 0 && sameSideCA >= 0)
                || (sameSideAB <= 0 && sameSideBC <= 0 && sameSideCA <= 0);
    }
}