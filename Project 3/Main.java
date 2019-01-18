import java.util.ArrayList;
import java.util.Random;
import java.lang.Double;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Measurable> shapes = new ArrayList<Measurable>();
		int RectangleCt = 0;
		int BoxCt = 0;
		int CircleCt = 0;
		int SphereCt = 0;
		
		for(int i = 0; i < 1000; i++) {
			Double chance = nextDouble();
			if (chance <= 0.25) {
				shapes.add(new Rectangle(nextDouble(), nextDouble()));
				RectangleCt += 1;
			}
			if (chance > 0.25 && chance <= 0.5) {
				shapes.add(new Box(nextDouble(), nextDouble(), nextDouble()));
				BoxCt += 1;
			}
			if (chance > 0.5 && chance <= 0.75) {
				shapes.add(new Circle(nextDouble()));
				CircleCt += 1;
			}
			if (chance > 0.75) {
				shapes.add(new Sphere(nextDouble()));
				SphereCt += 1;
			}
		}
		System.out.println("Rectangles: " + RectangleCt +
							"\nBoxes: " + BoxCt +
							"\nCircles: " + CircleCt +
							"\nSpheres: " + SphereCt +
							"\nTotal Area: " + calcuateSum(shapes));
	}	
	
	private static double calcuateSum(ArrayList<Measurable> shapeAL) {
		double areaSum = 0;
		
		for(int i = 0; i < shapeAL.size(); i++) {
			double area = shapeAL.get(i).getArea();
			areaSum += area;
		}
		return areaSum;
	}
	
	private static double nextDouble() {
		Random rand = new Random();
		double dub = rand.nextDouble();
		while (dub == Double.MIN_VALUE) {
			dub = rand.nextDouble();
		}
		return dub;
	}
}