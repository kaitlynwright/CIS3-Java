
public class Sphere extends Circle {
	private double radius;
	
	public Sphere (double radius) {
		super(radius);
	}
		
	public double getArea() {
		double surfaceArea = 4 * Math.PI * radius * radius;
		return surfaceArea;
	}
}
