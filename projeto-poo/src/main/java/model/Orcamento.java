/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Classe "Orcamento", que modela os objetos do tipo orçamento e suas informações
 * - Contém o seu método construtor, seus getters e setters e principais métodos:
 * 		- Buscar um orçamento pelo ID
 * 		- Definir os métodos de aprovar ou reprovar um orçamento
 * 		- Calcular o orçamento de um projeto
 * 
 * 
 * 
 * 	 * Definição dos status de orçamento:
	 * 
	 * - APROVADO: comprado pelo cliente
	 * - REPROVADO: recusado pelo cliente
	 * - PENDENTE: ainda sem resposta do cliente
 * 
 * @author fudelasq
 */
public class Orcamento {
	private int ID;
	private Status status;
	private double valor;
	
	// Atributos estáticos que definem valores fixos para custos e margem de lucro
	private static final double custoMaoObra = 500.0;
	private static final double custoEquipamentos = 250.0;
	private static final double margemLucro = 1.75; // Para calcular, será considerado 75% de margem de lucro
	
	
	// Construtor
	// Ao instanciar um objeto do tipo orçamento, o status automaticamente é definido como PENDENTE e só será alterado por meio 
	// de uma ação do cliente
	public Orcamento(int ID, Projeto projeto) {
		this.ID = ID;
		this.valor = calcularOrcamento(projeto);
		this.status = Status.PENDENTE;
	}
	
	// Métodos para definir um orçamento como aprovado ou reprovado
	public void aprovar() {
		this.status = Status.APROVADO;
	}
	
	public void reprovar() {
		this.status = Status.REPROVADO;
	}
	
	// Método para calcular o orçamento de um projeto
	// TODO: ajustar o método de calcular orçamento, de acordo com os os valores e quantidades de placas
	
	public double calcularOrcamento(Projeto projeto) {
		
		double totalPlacas = projeto.getModeloPlaca().getValor() * projeto.getQuantidadePlacas();
		double totalInversores = projeto.getModeloInversor().getValor() * projeto.getQuantidadeInversores();
		
		double custoTotal = totalPlacas + totalInversores + custoMaoObra + custoEquipamentos;
		double precoFinal = custoTotal * margemLucro;
		
		return precoFinal;
	}
	
	// Métodos getters e setters
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	private enum Status {
		APROVADO,
		REPROVADO,
		PENDENTE;
	}
    
}
