package moduloEmpresa.modelEmpresa;
import java.util.ArrayList;
import java.util.List;
import moduloEmpresa.database.Database;

public class Municipio {
	String nome;
	int irradiacaoAnual;
	
	// Construtor
	public Municipio(String nome, int irradiacaoAnual) {
		this.nome = nome;
		this.irradiacaoAnual = irradiacaoAnual;
	}
	
        // Método para buscar um município na lista de municípios
        public static Municipio buscarMunicipio(String nome) {
            for (Municipio municipio : Database.getTodosMunicipios()) {
                if (municipio.getNome().equals(nome)) {
                    return municipio;
                }
            }
            throw new IllegalArgumentException("O municipio informado é inválido.");
        }
        
	// Método para printar a lista de municípios
	public static void listarMunicipios() {
		for (Municipio municipio : Database.getTodosMunicipios()) {
			System.out.println("Nome: " + municipio.nome + 
                                            " | Irradiacao: " + municipio.irradiacaoAnual);
		}
	}
	
	// Métodos getters e setters
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