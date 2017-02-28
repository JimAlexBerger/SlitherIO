package neural;

import java.util.ArrayList;

public class NeuralNet {
	private int numInputs;
	private int numOutputs;
	private int numHiddenLayers;
	private int neuronsPerHiddenLayer;
	private NeuronLayer[] layers;
	
	public NeuralNet(int numInputs,int numOutputs,int numHiddenLayers,int neuronsPerHiddenLayer){
		this.numInputs = numInputs;
		this.numOutputs = numOutputs;
		this.numHiddenLayers = numHiddenLayers;
		this.neuronsPerHiddenLayer = neuronsPerHiddenLayer;
		
		this.layers = new NeuronLayer[1 + this.numHiddenLayers];
		if(this.numHiddenLayers > 0){			
			this.layers[0] = new NeuronLayer(this.neuronsPerHiddenLayer, this.numInputs);
		
			for(int i = 1; i < this.numHiddenLayers; i++){
				this.layers[i] = new NeuronLayer(this.neuronsPerHiddenLayer, this.layers[i-1].getNumNeurons());
			}
			
			this.layers[this.layers.length - 1] = new NeuronLayer(this.numOutputs, this.layers[this.layers.length - 2].getNumNeurons());

		}
		
	}
	
	public double[] getWeights(){
		ArrayList<Double> weights = new ArrayList<>();
		
		for(int i = 0; i < this.numHiddenLayers + 1; i++){
			for(int j = 0; j < this.layers[i].getNumNeurons(); j++){
				for(int k = 0; k < this.layers[i].getNeurons()[j].getWeights().length; k++){
					weights.add(this.layers[i].getNeurons()[j].getWeights()[k]);
				}
			}
		}
		
		double[] returnArray = new double[weights.size()];
		for(int i = 0; i < returnArray.length; i++){
			returnArray[i] = weights.get(i);
		}
		
		return returnArray;
	}
	
	public int getNumberOfWeights(){
		return this.getWeights().length;
	}
	
	public void putWeights(double[] weights){
		int count = 0;
		if(weights.length != this.getNumberOfWeights()){
			throw new IllegalArgumentException("Must have same ammount as in the net");
		}
		for(int i = 0; i < this.numHiddenLayers + 1; i++){
			for(int j = 0; j < this.layers[i].getNumNeurons(); j++){
				for(int k = 0; k < this.layers[i].getNeurons()[j].getNumInputs() + 1; k++){
					this.layers[i].getNeurons()[j].getWeights()[k] = weights[count++];
				}
			}
		}		
	}
	 
	public double[] update(double[] inputs){
		ArrayList<Double> temp = new ArrayList<Double>();
		for(double d : inputs) temp.add(d);
		return this.update(temp);
	}
	
	public double[] update(ArrayList<Double> inputs){
		ArrayList<Double> outputs = new ArrayList<>();
		int cWeights = 0;
		
		if(inputs.size() != this.numInputs){
			return new double[]{};
		}
		
		for(int i = 0; i < this.numHiddenLayers + 1; i++){
			if(i > 0){
				inputs = outputs;
			}
			
			outputs = new ArrayList<>();
			
			cWeights = 0;
			
			for(int j = 0; j < this.layers[i].getNumNeurons(); j++){
				double netInput = 0;
				
				int numInputs = this.layers[i].getNeurons()[j].getNumInputs();
				
				for(int k = 0; k < numInputs; k++){
					netInput += this.layers[i].getNeurons()[j].getWeights()[k] * inputs.get(cWeights++);
				}
				
				netInput += this.layers[i].getNeurons()[j].getWeights()[numInputs] * (-1);
				
				outputs.add(this.sigmoid(netInput, 1));
				
				cWeights = 0;
			}
		}
		
		double[] returnArray = new double[outputs.size()];
		 for (int i = 0; i < returnArray.length; i++) {
		    returnArray[i] = outputs.get(i).doubleValue();  
		 }
		
		return returnArray;
		
	}
	
	private double sigmoid(double activation, double response){
		return 1 / (1 + (Math.pow(Math.E, -activation / response)));
	}
}
