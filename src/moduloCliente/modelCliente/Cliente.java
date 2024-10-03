package moduloCliente.modelCliente;
import java.util.ArrayList;
import java.util.List;
import moduloEmpresa.modelEmpresa.Municipio;

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
    private final String nome;
    private final String telefone;
    private final Municipio municipio;
    private final String email;		// Usado para a autenticação no sistema
    private final String senha;		// Usado para a autenticação no sistema
    
    // Listas para armazenar todos os orcamentos feitos pelo cliente, e todos os projetos
    private List<Projeto> todosProjetos = new ArrayList<>();
    
    // Construtor
    public Cliente(String nome, Municipio municipio, String telefone, String email, String senha) {
    	this.nome = nome;
    	this.municipio = municipio;
    	this.telefone = telefone;
    	this.email = email;
    	this.senha = senha;
    	this.todosProjetos = new ArrayList<>();
    }
    
    // Autenticar cliente
    public boolean autenticarUsuario(String email, String senha) {
        return this.getEmail().equals(email) && this.getSenha().equals(senha);
    }
    
    // Métodos referentes ao gerenciamento de projetos do cliente
    public boolean adicionarProjeto(Projeto projeto) {
    	return todosProjetos.add(projeto);
    }
    
    public boolean removerProjeto(Projeto projeto) {
    	return todosProjetos.remove(projeto);
    }
    
    // Método para listar todos os orçamentos realizados pelo cliente
    public List<Projeto> listarProjetos() {
    	for (Projeto projeto: todosProjetos) {
    		// TODO: Adicionar a listagem na interface gráfica
    		System.out.println(projeto.toString());
    	}
        return todosProjetos;
    }
    
    // Método para procurar um projeto do cadastro do cliente
    public Projeto buscarProjetoPorId(int id) {
        for (Projeto projeto : todosProjetos) {
            if (projeto.getId() == id) {
                return projeto;
            }
        }
        return null;
    }
    
    // Método para procurar um projeto na lista de projetos
    public Projeto buscarProjeto(Projeto projeto) {
        
        if (projeto == null) {
            throw new IllegalArgumentException("O projeto informado é inválido!");
        }
        
        if (todosProjetos.contains(projeto)) {
            return projeto;
        }
        
        System.out.println("Não foi possível localizar o projeto selecionado.");
        return null;
    }
    
    // Getters e Setters dos atributos
	public String getNome() {
		return nome;
	}
        
        public Municipio getEndereco() {
                return municipio;
        }

	public Municipio getMunicipio() {
		return municipio;
	}
	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
        
	public String getSenha() {
		return senha;
	}

	public List<Projeto> getTodosProjetos() {
		return todosProjetos;
	}

}