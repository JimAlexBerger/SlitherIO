package snake;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.util.ArrayList;
import java.awt.Toolkit;
public class Snake {

	private int width;
	private int height;
	private Robot robot;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public Color[] gatherInfo(int numPoints) {
		Color[] points = new Color[numPoints];
		for(int i = 0; i < numPoints; i++){
			points[i] = robot.getPixelColor((width/2 + (int) Math.round(Math.cos(Math.toRadians(i)) * ((height/2)/numPoints)*i))  , (height/2 + (int) Math.round(Math.sin(Math.toRadians(i)) * ((height/2)/numPoints)*i)));
		}
		return points;
	}
	
	public Snake() {
		super();
		this.width = screenSize.width;
		this.height = screenSize.height;
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	
	public void moveMouse(double angle) {
		int x = (int) (Math.round(Math.cos(Math.toRadians(-angle))*50 + this.width/2));
		int y = (int) (Math.round(Math.sin(Math.toRadians(-angle))*50 + this.height/2));
		System.out.println(x);
		System.out.println(y);
		robot.mouseMove(x,y);
	}
	
	//TODO
	//1. Function that reads points?
	//2. 

}
