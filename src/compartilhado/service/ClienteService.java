package compartilhado.service;

import java.util.ArrayList;
import java.util.List;

import moduloCliente.modelCliente.Cliente;
import moduloCliente.modelCliente.Projeto;
import compartilhado.database.Database;
import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.Municipio;
import moduloEmpresa.modelEmpresa.PlacaSolar;
 
/* Classe de serviço que encapsula e centraliza a prestação de serviços voltados à empresa. 
*  Seus principais métodos são:
*   - Buscar um cliente na base de dados
*   - Cadastrar um cliente na base de dados 
*   - Solicitar um projeto (deve ser usada quando o cliente solicitar um projeto) 
*   - Aprovar ou recusar um orçamento feito pela empresa
*
*/

public class ClienteService {    
    // Método Singleton garantindo que existirá apenas uma instância do serviço    
    private static ClienteService instance;
    
    private ClienteService() {
    }
    
    public static ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService();
        }
        return instance;
    }
   
    // Buscar cliente na base de dados pelo email
    public Cliente buscarCliente(String email) {
    	try {
    		if (email == null || email.isEmpty()) {
    			throw new IllegalArgumentException("O email informado é invalido!");
    		} 
    		
    		if (Database.getTodosClientes().isEmpty()) {
    			throw new NullPointerException("Nenhum cliente cadastrado no sistema.");
    		}
    		    		
    		for (Cliente cliente : Database.getTodosClientes()) {
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
        
        try {    
            Municipio municipio = Municipio.buscarMunicipio(endereco); // Alterar caso seja fornecido o objeto Municipio

            validarDadosCliente(nome, municipio, telefone, email, senha);

            if (emailDisponivel(email)) {
                    Cliente novoCliente = new Cliente(nome, municipio, telefone, email, senha);
                    Database.adicionarElemento(novoCliente, Database.TipoLista.CLIENTE);
                    System.out.println("Cliente cadastrado com sucesso!");
                    return novoCliente;
            }
            throw new IllegalArgumentException("Já existe uma conta cadastrada com o email informado.");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
            return null;
        }
    }
    
    // Verificar se já existe uma conta cadastrada com o email informado
    private boolean emailDisponivel(String email) {
    	
    	for (Cliente cliente : Database.getTodosClientes()) {
    		if (cliente.getEmail().equals(email)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    // TODO: Lógica para permitir que o cliente aprove ou recuse um orçamento

    // Método para verificar se os dados informados são válidos
    private void validarDadosCliente(String nome, Municipio municipio, String telefone, String email, String senha) {
    	if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
    	
    	if (municipio == null) {
            throw new IllegalArgumentException("O municipio informado é inválido.");
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
    
    public Projeto solicitarProjeto(int consumoMensal, Cliente cliente) {
        try {
            Projeto novoProjeto = ProjetoService.criarProjeto(cliente, cliente.getMunicipio(), consumoMensal);
        return novoProjeto;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar o novo projeto: " + e.getMessage());
            return null;
        }
    }    

    // Método para permitir ao cliente decidir se aprova ou não um orçamento
    public void avaliarOrcamento(Cliente cliente, Projeto projeto, boolean aprovado) {
        if (projeto == null || cliente == null) {
            throw new IllegalArgumentException("Cliente ou projeto invalidos.");
        }
        Projeto projetoEncontrado = cliente.buscarProjeto(projeto);
        if (projetoEncontrado != null) {
            if (aprovado) {
                projeto.aprovarProjeto();
            } else {
                projeto.reprovarProjeto();
            }
        } else {
            throw new IllegalArgumentException("O projeto selecionado nao pertence ao cliente.");
        }
    }
    
}
