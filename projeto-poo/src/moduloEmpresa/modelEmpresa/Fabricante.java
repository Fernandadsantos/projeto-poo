package moduloEmpresa.modelEmpresa;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que permite cadastrar novos fabricantes no sistema, e listá-los
 * @author fudel
 */
public class Fabricante {
    private String nome;
    
    // Lista estática que armazena todos os fabricantes de equipamentos
    private static List<Fabricante> todosFabricantes = new ArrayList<>();
    
    // Construtor
    public Fabricante(String nome) {
    	this.nome = nome;
    	todosFabricantes.add(this);
    }
    
    // Métodos getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<Fabricante> getTodosFabricantes() {
		return todosFabricantes;
	}

	public static void setTodosFabricantes(List<Fabricante> todosFabricantes) {
		Fabricante.todosFabricantes = todosFabricantes;
	}
}
