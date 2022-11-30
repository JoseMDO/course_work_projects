package CircleCalc;
import java.util.Random;


public class CircleCalc {
    public static void main(String[]args) {
    Random rnd = new Random();
    int radius = rnd.nextInt(100);
    double area = Math.PI * (radius * radius);
    double circumference = 2 * Math.PI * radius;
    System.out.printf("The random radius that was selected was: %d\n", radius);
    System.out.printf("The area for a circle with this radius is: %.2f \n", area);
    System.out.printf("The circumference for a circle with this radius is: %.2f", circumference);

    }
}
