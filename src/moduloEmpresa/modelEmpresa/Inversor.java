package moduloEmpresa.modelEmpresa;

/**
 * Classe que herda da classe Equipamento, e permite a criação de modelos diferentes de inversores
 * 
 * @author fudelasq
 */
public class Inversor extends Equipamento {
  
	// Construtor do tipo Inversor
	public Inversor(Fabricante fabricante, double valor, int potencia) {
		super(fabricante, valor);
                this.setTipo(TipoEquipamento.INVERSOR);
		this.setCapacidade(potencia);
        }
}