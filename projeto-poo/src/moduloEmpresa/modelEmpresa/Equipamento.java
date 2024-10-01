package moduloEmpresa.modelEmpresa;

/**
 * Classe abstrata Equipamento, que não será instanciada pois apenas servirá como referência para os tipos de equipamento
 * 
 * @author fudelasq
 */
public abstract class Equipamento {
    Fabricante fabricante;
    double valor;
    TipoEquipamento tipo;
    
    // Construtor vazio, pois será instanciada apenas pelas classes herdeiras
    public Equipamento(Fabricante fabricante, double valor) {
    	this.fabricante = fabricante;
    	this.valor = valor;
    }
    
    // Método para exibir as informações de um equipamento
    public abstract void exibirInfos();
    
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
    
    public enum TipoEquipamento {
        INVERSOR,
        PLACASOLAR;
    }
}