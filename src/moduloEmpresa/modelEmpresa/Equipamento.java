package moduloEmpresa.modelEmpresa;

/**
 * Classe abstrata Equipamento, que não será instanciada pois apenas servirá como modelo para os tipos de equipamento
 * 
 * @author fudelasq
 */
public abstract class Equipamento {
    private Fabricante fabricante;
    private TipoEquipamento tipo;
    private int capacidade; // Será definida em watts
    private double valor;

    
    // Construtor vazio, pois será instanciada apenas pelas classes herdeiras
    public Equipamento(Fabricante fabricante, double valor) {
    	this.fabricante = fabricante;
    	this.valor = valor;
    }
    
    // Método para exibir as informações de um equipamento
    public String exibirInfos() {
        String infos = "Tipo de equipamento: " + this.getTipo().toString() +
                        "\nFabricante: " + this.fabricante.getNome() +
                        "\nValor: " + this.getValor() + 
                        "\nPotencia/Capacidade(W): " + this.getCapacidade();
        return infos;
    }
    
    // Métodos getters e setters
    
	public Fabricante getFabricante() {
            return fabricante;
	}
        
        public void setFabricante(Fabricante fabricante) {
            this.fabricante = fabricante;
        }

	public double getValor() {
		return valor;
	}
        
	public void setValor(double valor) {
		this.valor = valor;
	}
        
        public int getCapacidade() {
            return capacidade;
        }
        
        public void setCapacidade(int capacidade) {
            this.capacidade = capacidade;
        }
        
        public TipoEquipamento getTipo() {
            return tipo;
        }
        
        public void setTipo(TipoEquipamento tipo) {
            this.tipo = tipo;
        }
    
    public enum TipoEquipamento {
        INVERSOR,
        PLACASOLAR;
    }
}