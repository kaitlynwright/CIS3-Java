import java.awt.Color;
import java.awt.Graphics;

public class Point {
	public static final int small = 1;
	public static final int medium = 2;
	public static final int large = 3;
	
	private int x;
	private int y;
	private Color color;
	private int size;
	
	public Point(int x, int y, Color color, int size) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		switch (size) {
			case small:
				g.fillOval(x, y, 10, 10);
				break;
			case medium:
				g.fillOval(x, y, 20, 20);
				break;
			case large:
				g.fillOval(x, y, 30, 30);
				break;
		}
	}
}
