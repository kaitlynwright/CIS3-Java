
public class Rectangle implements Measurable {
	private double length;
	private double width;
	
	public Rectangle (double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getArea() {
		double area = length * width;
		return area;
	}
}
