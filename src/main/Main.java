package main;

import java.awt.event.KeyEvent;
import java.util.Arrays;

import neural.NeuralNet;
import snake.Snake;

public class Main {
	private static Snake snake = new Snake();;
	public static void main(String[] args) {
		NeuralNet n = new NeuralNet(4, 2, 3, 4);
		System.out.println(Arrays.toString(n.update(new double[]{1,2,3,25})));
		System.out.println(Arrays.toString(snake.gatherInfo(10)));

		
		
		
	}
	public void keyTyped(KeyEvent event) {
	    
	   
	}

}
