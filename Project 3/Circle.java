
public class Circle implements Measurable {
	private double radius;
	
	public Circle (double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
}
