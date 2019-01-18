
public class Box extends Rectangle {
	private double length;
	private double width;
	private double height;
	
	public Box (double length, double width, double height) {
		super(width, length);
		this.height = height;
	}
	
	public double getArea() {
		double surfaceArea = (2 * length * width) + (2 * length * height) + (2 * width * height);
		return surfaceArea;
	}
}
