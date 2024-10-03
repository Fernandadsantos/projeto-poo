package moduloCliente.modelCliente;

import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.Municipio;
import moduloEmpresa.modelEmpresa.PlacaSolar;

/**
 * Classe "Projeto", que modela os objetos do tipo proejto  e suas informações
 * - Contém o seu método construtor, seus getters e setters e principais métodos:
 * 		- Calcular a quantidade de painéis solares que são necessários de acordo com as especificações do cliente
 *
 * O projeto possui 3 status, definidos como:
 *  - CRIADO: Quando o cliente solicita um novo projeto e ainda não foi validado por um funcionário
 *  - DIMENSIONADO: Quando o cliente dimensiona o projeto solicitado e é enviado para a aprovação do cliente
 *  - FINALIZADO: Quando o cliente recebe a proposta de projeto e reprova ou aprova o projeto
 * 
 * @author fudelasq
 */
public class Projeto {
    private int quantidadePlacas;
    private int quantidadeInversores;
    private int consumoMensalEnergia;
    private int id;
    private double orcamento;
    private Status status;
        
    private PlacaSolar modeloPlaca;
    private Inversor modeloInversor;
    private Municipio municipio;
    private Cliente cliente;

    // Contador estático para controlar a quantidade de projetos
    private static int counter = 0;
        
    // Método construtor do tipo Projeto
    public Projeto(Cliente cliente, Municipio municipio, int consumoMensal) {
        this.municipio = municipio;
        this.consumoMensalEnergia = consumoMensal;
        this.cliente = cliente;
        this.id = ++counter;
        this.status = Projeto.Status.CRIADO;
        this.orcamento = 0.0;
                
        // Todos os demais atributos serão definidos posteriormente nos métodos
	this.modeloPlaca = null;
	this.modeloInversor = null;
	this.quantidadePlacas = 0;
	this.quantidadeInversores = 0;
    }
	
    // Método para calcular a quantidade de painéis
    public int calcularQuantidadePaineis(int consumo, Municipio municipio, PlacaSolar placa) {
	int quantidade = (consumo) / (municipio.getIrradiacaoAnual() * placa.getCapacidade() * 30); 
		
	if (quantidade < 0) {
            quantidade = 1;
	}
        this.quantidadePlacas = quantidade;
        return quantidade;
    }
        
        // Método para calcular a potência total das placas 
        public int calcularPotenciaTotalPlacas(PlacaSolar placa, int quantidadePlacas) {
            int potencia = quantidadePlacas * placa.getCapacidade();
            return potencia;
        }
        
    // Método para calcular a potência total necessária de inversores
    public int calcularQuantidadeInversores(int quantidadePlacas, Inversor inversor, PlacaSolar placa) {
        int potenciaInversores = calcularPotenciaTotalPlacas(placa, quantidadePlacas);
            
        if (inversor.getCapacidade() <= 0) {
            throw new IllegalArgumentException("A capacidade do inversor deve ser maior que zero.");
        }

        int quantidadeInversores = (int) Math.ceil((double) potenciaInversores / inversor.getCapacidade());
        
        this.quantidadeInversores = quantidadeInversores;
        return quantidadeInversores;   
    }
	
    // Método para setar o status do projeto como Dimensionado
        public void dimensionarProjeto() {
            this.status = Projeto.Status.DIMENSIONADO;
        }
        
        // Método para setar o status do projeto como finalizado
        public void finalizarProjeto() {
            this.status = Projeto.Status.FINALIZADO;
        }
        
        // Método para setar o status do projeto como aprovado;
        public void aprovarProjeto() {
            this.status = Projeto.Status.APROVADO;
        }
               
        // Método para setar o status do projeto como recusado;
        public void reprovarProjeto() {
            this.status = Projeto.Status.REPROVADO;
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
        
        public double getOrcamento() {
            return orcamento;
        }
	
        public int getId() {
            return id;
        }
        
        public void setId(int id) {
            this.id = id;
        }
        
        public Status getStatus() {
            return this.status;
        }
        
    public static enum Status {
        CRIADO,
        DIMENSIONADO,
        APROVADO,
        REPROVADO,
        FINALIZADO;
    }
}
