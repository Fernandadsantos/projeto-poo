/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

import service.ClienteService;

/**
 * Classe "Cliente", que modela os objetos do tipo cliente e suas informações
 * - Contém o seu método construtor, seus getters e setters e principais métodos:
 * 		- Verificar senha de autenticação do sistema
 * 		- Gerenciamento de orçamentos e projetos do cliente
 * 		- Exibir as informações de todos os orçamentos de um cliente
 * 		- Permitir que o cliente aprove ou reprove um orçamento
 * 
 * 
 * @author fudelasq
 */
public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;		// Usado para a autenticação no sistema
    private String senha;		// Usado para a autenticação no sistema
    
    // Listas para armazenar todos os orcamentos feitos pelo cliente, e todos os projetos
    private List<Orcamento> todosOrcamentos = new ArrayList<>();
    private List<Projeto> todosProjetos = new ArrayList<>();
    
    // Construtor
    public Cliente(String nome, String endereco, String telefone, String email, String senha) {
    	this.nome = nome;
    	this.endereco = endereco;
    	this.telefone = telefone;
    	this.email = email;
    	this.senha = senha;
    	this.todosOrcamentos = new ArrayList<>();
    	this.todosProjetos = new ArrayList<>();
    }

	// Método para checar se a senha inserida na tela de login é a mesma senha cadastrada
    public boolean verificarSenha(String senha) {
    	return this.getSenha().equals(senha);
    }
    
    
    // Métodos referentes ao gerenciamento de orçamentos do cliente
    public boolean adicionarOrcamento(Orcamento orcamento) {
    	return todosOrcamentos.add(orcamento);
    }
    
    public boolean removerOrcamento(Orcamento orcamento) {
    	return todosOrcamentos.remove(orcamento);
    }
    
    // Métodos referentes ao gerenciamento de projetos do cliente
    public boolean adicionarProjeto(Projeto projeto) {
    	return todosProjetos.add(projeto);
    }
    
    public boolean removerProjeto(Projeto projeto) {
    	return todosProjetos.remove(projeto);
    }
    
    // Método para listar todos os orçamentos realizados pelo cliente
    public void listarOrcamentos() {
    	for (Orcamento orcamento: todosOrcamentos) {
    		// TODO: Adicionar a listagem na interface gráfica
    		System.out.println(orcamento.toString());
    	}
    }
    
    // Método para permitir ao cliente decidir se aprova ou não um orçamento
    public void decidirOrcamento(Orcamento orcamento, boolean aprovado) {
    
    		if (aprovado) {
    			orcamento.aprovar();
    			//TODO: adicionar a confirmação na interface gráfica
    			System.out.println("Orcamento #" + orcamento.getID() + "aprovado!");
    		} else {
    			orcamento.reprovar();
    			System.out.println("Orcamento #" + orcamento.getID() + "reprovado!");
    		}
    }
    
    // Getters e Setters dos atributos
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Orcamento> getTodosOrcamentos() {
		return todosOrcamentos;
	}

	public void setTodosOrcamentos(List<Orcamento> todosOrcamentos) {
		this.todosOrcamentos = todosOrcamentos;
	}

	public List<Projeto> getTodosProjetos() {
		return todosProjetos;
	}

	public void setTodosProjetos(List<Projeto> todosProjetos) {
		this.todosProjetos = todosProjetos;
	}

}
