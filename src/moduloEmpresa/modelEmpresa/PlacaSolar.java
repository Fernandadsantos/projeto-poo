package moduloEmpresa.modelEmpresa;

/**
 * Classe que herda da classe Equipamento, e permite a criação de modelos diferentes de placas solares
 * 
 * 
 * 
 * @author fudelasq
 */
public class PlacaSolar extends Equipamento {
    
    // Construtor do tipo PlacaSolar
    public PlacaSolar(Fabricante fabricante, double valor, int capacidade) {
    	super(fabricante, valor);
        this.setTipo(TipoEquipamento.PLACASOLAR);
    	this.setCapacidade(capacidade);
    }
    
}