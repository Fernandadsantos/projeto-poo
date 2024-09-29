/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Classe "Projeto", que modela os objetos do tipo proejto  e suas informações
 * - Contém o seu método construtor, seus getters e setters e principais métodos:
 * 		- Calcular a quantidade de painéis solares que são necessários de acordo com as especificações do cliente
 *
 * @author fudelasq
 */
public class Projeto {
	int quantidadePlacas;
	int quantidadeInversores;
	int consumoMensalEnergia;
	PlacaSolar modeloPlaca;
	Inversor modeloInversor;
	Municipio municipio;
	
	// Método construtor do tipo Projeto
	public Projeto(PlacaSolar placa, Inversor inversor, Municipio municipio, int consumoMensal) {
		this.modeloPlaca = placa;
		this.modeloInversor = inversor;
		this.municipio = municipio;
		this.consumoMensalEnergia = consumoMensal;
		this.quantidadePlacas = calcularQuantidadePaineis(consumoMensal, municipio, placa);
		this.quantidadeInversores = 0; // TODO: Ajustar o cálculo da quantidade de inversores
	}
	
	private int calcularQuantidadePaineis(int consumo, Municipio municipio, PlacaSolar placa) {
		int quantidade = (consumo) / (municipio.getIrradiacaoAnual() * placa.getCapacidade() * 30); 
		
		if (quantidade > 0) {
			return quantidade;			
		} else {
			return 1;
		}
	}
	
	// Métodos getters e setters
	public int getQuantidadePlacas() {
		return quantidadePlacas;
	}
	public int getQuantidadeInversores() {
		return quantidadeInversores;
	}

	public int getConsumoMedioEnergia() {
		return consumoMensalEnergia;
	}

	public PlacaSolar getModeloPlaca() {
		return modeloPlaca;
	}

	public Inversor getModeloInversor() {
		return modeloInversor;
	}
	
}
