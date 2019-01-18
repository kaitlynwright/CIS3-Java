import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private final JButton _black;
	private final JButton _red;
	private final JButton _green;
	private final JButton _blue;
	private final JButton _small;
	private final JButton _medium;
	private final JButton _large;
	private final JButton _clear;
	private JLabel _label = new JLabel();
	private JLabel _colorLabel = new JLabel();
	private JLabel _sizeLabel = new JLabel();
	
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		setLayout(new BorderLayout());
		
		PaintPanel panel = new PaintPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		
		JPanel colorsPanel = new JPanel();
		colorsPanel.setLayout(new GridLayout(5, 1));
		
		JPanel sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(5,1));
		
		_black = new JButton("Black");
		_black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Black Clicked!");
				panel.setColor(Color.BLACK);
			}			
		});
				
		_red = new JButton("Red");
		_red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Red Clicked!");
				panel.setColor(Color.RED);
			}			
		});
				
		_blue = new JButton("Blue");
		_blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Blue Clicked!");
				panel.setColor(Color.BLUE);
			}			
		});
		
		_green = new JButton("Green");
		_green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Green Clicked!");
				panel.setColor(Color.GREEN);
			}			
		});
		
		_small = new JButton("Small");
		_small.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Small Clicked!");
				panel.setSize(Point.small);
			}			
		});	
			
		_medium = new JButton("Medium");
		_medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Medium Clicked!");
				panel.setSize(Point.medium);
			}			
		});
		
		_large = new JButton("Large");
		_large.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Large Clicked!");
				panel.setSize(Point.large);
			}			
		});
		
		_clear = new JButton("Clear");
		_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_label.setText("Clear Clicked!");
				panel._points.clear();
				panel.repaint();
			}			
		});
		
		_label = new JLabel("NO button clicked!");
		_colorLabel = new JLabel("Choose a color.");
		_sizeLabel = new JLabel("Choose a size.");
		
		add(colorsPanel, BorderLayout.WEST);
		add(panel, BorderLayout.CENTER);
		add(sizePanel, BorderLayout.EAST);
		add(_label, BorderLayout.SOUTH);
		
		colorsPanel.add(_colorLabel);
		colorsPanel.add(_black);
		colorsPanel.add(_red);
		colorsPanel.add(_blue);
		colorsPanel.add(_green);
		
		sizePanel.add(_sizeLabel);
		sizePanel.add(_small);
		sizePanel.add(_medium);
		sizePanel.add(_large);
		sizePanel.add(_clear);
	}
}

