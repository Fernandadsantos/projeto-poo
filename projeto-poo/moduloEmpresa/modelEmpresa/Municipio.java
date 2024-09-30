package model;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
	String nome;
	int irradiacaoAnual;
	
	// Lista estática com todos os municípios do estado de Sergipe
	// e suas respectivas taxas de irradiação anual
	public static List<Municipio> todosMunicipios = new ArrayList<>();
	
	// Construtor
	public Municipio(String nome, int irradiacaoAnual) {
		this.nome = nome;
		this.irradiacaoAnual = irradiacaoAnual;
		todosMunicipios.add(this);
	}
	
	// Método para printar a lista de municípios
	public static void listarMunicipios() {
		for (Municipio municipio : todosMunicipios) {
			System.out.println("Nome: " + municipio.nome + 
								" | Irradiacao: " + municipio.irradiacaoAnual);
		}
	}
	
	// Métodos getters e setters
	public static List<Municipio> getTodosMunicipios() {
		return todosMunicipios;
	}

	public static void setTodosMunicipios(List<Municipio> todosMunicipios) {
		Municipio.todosMunicipios = todosMunicipios;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIrradiacaoAnual() {
		return irradiacaoAnual;
	}
	public void setIrradiacaoAnual(int irradiacaoAnual) {
		this.irradiacaoAnual = irradiacaoAnual;
	}
}