package moduloCliente.modelCliente;

import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.Municipio;
import moduloEmpresa.modelEmpresa.PlacaSolar;

/**
 * Classe "Projeto", que modela os objetos do tipo proejto  e suas informações
 * - Contém o seu método construtor, seus getters e setters e principais métodos:
 * 		- Calcular a quantidade de painéis solares que são necessários de acordo com as especificações do cliente
 *
 * @author fudelasq
 */
public class Projeto {
	int quantidadePlacas;
	int quantidadeInversores;
	int consumoMensalEnergia;
        int id;
        
	PlacaSolar modeloPlaca;
	Inversor modeloInversor;
	Municipio municipio;
        Orcamento orcamento;

	// Contador estático para controlar a quantidade de projetos
        private static int counter = 0;
        
	// Método construtor do tipo Projeto
	public Projeto(PlacaSolar placa, Inversor inversor, Municipio municipio, int consumoMensal) {
		this.modeloPlaca = placa;
		this.modeloInversor = inversor;
		this.municipio = municipio;
		this.consumoMensalEnergia = consumoMensal;
		this.quantidadePlacas = 0;
		this.quantidadeInversores = 0; // TODO: Ajustar o cálculo da quantidade de inversores
                this.orcamento = new Orcamento(this);
                this.id = ++counter;
	}
	
        // Método para calcular a quantidade de painéis
	private int calcularQuantidadePaineis(int consumo, Municipio municipio, PlacaSolar placa) {
		int quantidade = (consumo) / (municipio.getIrradiacaoAnual() * placa.getCapacidade() * 30); 
		
		if (quantidade > 0) {
			return quantidade;			
		} else {
			return 1;
		}
	}
	
	// Métodos getters e setters
        public void setQuantidadePlacas(int quantidadePlacas) {
            this.quantidadePlacas = quantidadePlacas;
        }
        
        public void setQuantidadeInversores(int quantidadeInversores) {
            this.quantidadeInversores = quantidadeInversores;
        }
        
	public int getQuantidadePlacas() {
		return quantidadePlacas;
	}
	public int getQuantidadeInversores() {
		return quantidadeInversores;
	}

	public int getConsumoMedioEnergia() {
		return consumoMensalEnergia;
	}

	public PlacaSolar getModeloPlaca() {
		return modeloPlaca;
	}

	public Inversor getModeloInversor() {
		return modeloInversor;
	}
        
        public Orcamento getOrcamento() {
                return orcamento;
        }
	
        public int getId() {
                return id;
        }
        
}
