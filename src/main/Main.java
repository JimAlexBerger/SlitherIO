package main;

import java.util.Arrays;

import neural.NeuralNet;

public class Main {

	public static void main(String[] args) {
		NeuralNet n = new NeuralNet(4, 2, 3, 4);
		System.out.println(Arrays.toString(n.update(new double[]{1,2,3,25})));
	}

}
