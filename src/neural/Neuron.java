package neural;

import java.util.Arrays;

public class Neuron {
	private int numInputs;
	private double[] weights;
	
	public Neuron(int numInputs){
		this.numInputs = numInputs;
		
		this.weights = new double[this.numInputs + 1];
		for(int i = 0; i < numInputs + 1; i++){
			weights[i] = Math.random()*2 - 1;
		}
	}

	public int getNumInputs() {
		return numInputs;
	}

	public void setNumInputs(int numInputs) {
		this.numInputs = numInputs;
	}

	public double[] getWeights() {
		return weights;
	}
	
	public String toString(){
		return Arrays.toString(this.weights);
	}

}
