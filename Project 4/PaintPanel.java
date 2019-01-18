import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<Point> _points;
	
	private static Color _currentColor;
	private static int _currentSize;

	public PaintPanel() {
		_points = new ArrayList<>();
		_currentColor = Color.BLACK;
		_currentSize = Point.small;
		
		MouseAdapter adapter = new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent e){
					Point point = new Point(e.getX(), e.getY(), _currentColor, _currentSize);
					_points.add(point);
					repaint();
				}
			};
			
			addMouseListener(adapter);
			addMouseMotionListener(adapter);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(_currentColor);
			
			for (Point point : _points) {
				point.draw(g);
			}
		}
		
		public void setColor(Color color) {
			_currentColor = color;
		}
		
		public void setSize(int size) {
			_currentSize = size;
		}		
}
	