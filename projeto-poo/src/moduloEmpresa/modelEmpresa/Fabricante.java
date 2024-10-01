package moduloEmpresa.modelEmpresa;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que permite cadastrar novos fabricantes no sistema, e listá-los
 * @author fudel
 */
public class Fabricante {
    private String nome;
    
    // Construtor
    public Fabricante(String nome) {
    	this.nome = nome;
    }
    
    // Métodos getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
