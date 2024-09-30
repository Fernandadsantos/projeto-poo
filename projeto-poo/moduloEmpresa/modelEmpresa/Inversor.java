/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Classe que herda da classe Equipamento, e permite a criação de modelos diferentes de inversores
 * 
 * @author fudelasq
 */
public class Inversor extends Equipamento {
	int potencia;
  
	// Construtor do tipo Inversor
	public Inversor(Fabricante fabricante, double valor, int potencia) {
		super(fabricante, valor);
		this.potencia = potencia;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public void exibirInfos() {
		System.out.println("Dados do inversor:");
		System.out.println("Capacidade (Watts): " + this.getPotencia() + 
							"Fabricante: " + this.getFabricante().toString() + 
							"Valor: " + this.getValor());
		
	}
    
}
