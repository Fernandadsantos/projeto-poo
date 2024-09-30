/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Classe que herda da classe Equipamento, e permite a criação de modelos diferentes de placas solares
 * 
 * 
 * 
 * @author fudelasq
 */
public class PlacaSolar extends Equipamento {
    int capacidade; // Será definida em watts
    
    // Construtor do tipo PlacaSolar
    public PlacaSolar(Fabricante fabricante, double valor, int capacidade) {
    	super(fabricante, valor);
    	this.capacidade = capacidade;
    }

    
    // Métodos getters e setters
	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}


	@Override
	// TODO: implementar a exibição de informações na interface gráfica
	public void exibirInfos() {
		System.out.println("Dados da placa solar:");
		System.out.println("Capacidade (Watts): " + this.getCapacidade() + 
							"Fabricante: " + this.getFabricante().toString() + 
							"Valor: " + this.getValor());
	}
    
}
