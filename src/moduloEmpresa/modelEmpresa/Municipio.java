package moduloEmpresa.modelEmpresa;
import java.util.ArrayList;
import java.util.List;
import compartilhado.database.Database;

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
            throw new IllegalArgumentException("Municipio nao encontrado.");
        }
        
	// Método para printar a lista de municípios
	public static String listarMunicipios() {
	    StringBuilder resultado = new StringBuilder(); // Usar StringBuilder para melhor performance na concatenação
            List<Municipio> municipios = Database.getTodosMunicipios();

            if (municipios.isEmpty()) {
                return "Nenhum município encontrado.";
            }

            for (Municipio municipio : municipios) {
                String info = "===========\n" +
                              "Município: " + municipio.getNome() +
                              "\nIrradiação anual: " + municipio.getIrradiacaoAnual() + "\n===========\n";
                resultado.append(info); // Acumula informações
                System.out.println(info);
            }

            return resultado.toString();
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