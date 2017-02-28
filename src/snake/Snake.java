package snake;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.util.ArrayList;
import java.awt.Toolkit;
public class Snake {

	private int snakeLength = 10;
	private int timeMultiplier;
	private Robot robot;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	//TO DO VARIEBLES
	
	//neural net
	
	//TO DO METHODS
	public ArrayList<Color> gatherInfo() {
		ArrayList<Color> array = new ArrayList<>();
		array.add(robot.getPixelColor(20, 20));
		array.add(robot.getPixelColor(40, 40));
		array.add(robot.getPixelColor(60, 60));
		array.add(robot.getPixelColor(80, 80));
		array.add(robot.getPixelColor(100, 100));
		return array;

	}
	
	public Snake() {
		super();
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	
	//GETINPUTS(rgb values at screen put into array)
	public void moveMouse(double angle) {
		int x = (int) (Math.round(Math.cos(Math.toRadians(-angle))*50 + screenSize.width/2));
		int y = (int) (Math.round(Math.sin(Math.toRadians(-angle))*50 + screenSize.height/2));
		System.out.println(x);
		System.out.println(y);
		robot.mouseMove(x,y);
	}
	//FROM angle to mouse pos(use cos and sin)

}
