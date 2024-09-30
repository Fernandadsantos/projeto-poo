package service;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteService {
	
    // Lista estática que armazena todos os clientes cadastrados na plataforma
    public static List<Cliente> todosClientes = new ArrayList<>();
   
    // Buscar cliente na base de dados pelo email
    public static Cliente buscarCliente(String email) {
    	try {
    		if (email == null || email.isEmpty()) {
    			throw new IllegalArgumentException("O email informado é invalido!");
    		} 
    		
    		if (todosClientes.isEmpty()) {
    			throw new NullPointerException("Nenhum cliente cadastrado no sistema.");
    		}
    		    		
    		for (Cliente cliente : todosClientes) {
    			if (cliente.getEmail().equals(email)) {
    				return cliente;
    			}
    		}
    		
    		System.out.println("Nenhuma conta com email: " + email + " foi localizada.");
    		return null;
    		
    	} catch (IllegalArgumentException | NullPointerException e) {
    		e.printStackTrace();
    	}
		return null;
    }
    
    
    // Chamar o método construtor de cliente caso o email esteja disponível
    public Cliente cadastrarCliente(String nome, String endereco, String telefone, String email, String senha) {
    	
    	validarDadosCliente(nome, endereco, telefone, email, senha);
    	
    	if (emailDisponivel(email)) {
    		Cliente novoCliente = new Cliente(nome, endereco, telefone, email, senha);
        	todosClientes.add(novoCliente);
        	System.out.println("Cliente cadastrado com sucesso!");
    		return novoCliente;
    	}
    	System.out.println("O email informado já está associado a uma conta existente.");
    	return null;
    }
    
    // Verificar se já existe uma conta cadastrada com o email informado
    public static boolean emailDisponivel(String email) {
    	
    	for (Cliente cliente : todosClientes) {
    		if (cliente.getEmail().equals(email)) {
    			return false;
    		}
    	}
    	return true;
    }

    // Método para verificar se os dados informados são válidos
    private void validarDadosCliente(String nome, String endereco, String telefone, String email, String senha) {
    	if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
    	
    	if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("O endereco não pode estar vazio.");
        }
    	
    	if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("O telefone informado é inválido.");
        }
    	
        if (email == null || email.isEmpty() || !email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {            
        	throw new IllegalArgumentException("O email informado é inválido.");
        }
    	
    	if (senha == null || senha.isEmpty()) {		// Verificar se é necessário validar o tamanho da senha
            throw new IllegalArgumentException("O senha não pode estar vazia.");
        }
    	
    }
    
	public static List<Cliente> getTodosClientes() {
		return todosClientes;
	}

	public static void setTodosClientes(List<Cliente> todosClientes) {
		ClienteService.todosClientes = todosClientes;
	}	
    
}
