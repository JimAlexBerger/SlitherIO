package neural;

import neural.Neuron;

public class NeuronLayer {
	private int numNeurons;
	private Neuron[] neurons;
	
	public NeuronLayer(int numNeurons, int numInputsPerNeuron){
		this.numNeurons = numNeurons;
		
		this.neurons = new Neuron[this.numNeurons];
		for(int i = 0; i < this.numNeurons; i++){
			neurons[i] = new Neuron(numInputsPerNeuron);
		}
	}

	public int getNumNeurons() {
		return numNeurons;
	}

	public void setNumNeurons(int numNeurons) {
		this.numNeurons = numNeurons;
	}

	public Neuron[] getNeurons() {
		return neurons;
	}
}
