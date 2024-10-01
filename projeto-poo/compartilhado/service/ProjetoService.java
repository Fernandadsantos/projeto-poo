package compartilhado.service;

import moduloCliente.modelCliente.Cliente;
import moduloCliente.modelCliente.Orcamento;
import moduloCliente.modelCliente.Projeto;
import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.Municipio;
import moduloEmpresa.modelEmpresa.PlacaSolar;

public class ProjetoService {
    // Método Singleton garantindo que existirá apenas uma instância do serviço    
    private static ProjetoService instance;
    
    private ProjetoService() {
        
    } 
        
    public static ProjetoService getInstance() {
        if (instance == null) {
            instance = new ProjetoService();
        }
        return instance;
    }
    
    public Projeto criarProjeto(PlacaSolar placa, Inversor inversor, Municipio municipio, int consumoMensal) {
        try {
        Projeto novoProjeto = new Projeto(placa, inversor, municipio, consumoMensal);
        return novoProjeto;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar o novo projeto: " + e.getMessage());
            return null;
        }
    }
    
    // Método para permitir ao cliente decidir se aprova ou não um orçamento
    public void decidirOrcamento(Cliente cliente, Projeto projeto, boolean aprovado) {
        
        if (projeto == null || cliente == null) {
            throw new IllegalArgumentException("Cliente ou projeto inválidos.");
        }
        
        Projeto projetoEncontrado = cliente.buscarProjeto(projeto);
        
        if (projetoEncontrado != null) {
            if (aprovado) {
                projeto.getOrcamento().aprovar();
            //TODO: adicionar a confirmação na interface gráfica
            } else {
                projeto.getOrcamento().reprovar();
            //TODO: adicionar a confirmação na interface gráfica
            }
        } else {
            throw new IllegalArgumentException("O projeto selecionado não pertence ao cliente.");
        }
    }
  
    // Método para solicitar um novo projeto 
    public Projeto solicitarProjeto(Cliente cliente, Inversor inversor, PlacaSolar placa, int consumoMensal) {
        try {
            validarDadosProjeto(cliente, inversor, placa, cliente.getMunicipio(), consumoMensal);

            Projeto novoProjeto = new Projeto(placa, inversor, cliente.getMunicipio(), consumoMensal);
            cliente.adicionarProjeto(novoProjeto);
            System.out.println("Projeto solicitado com sucesso!");
            return novoProjeto;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao solicitar projeto: " + e.getMessage());
            return null;
        }
    }
    
    // Método para validar se os dados informados são válidos
    private void validarDadosProjeto(Cliente cliente, Inversor inversor, PlacaSolar placa, Municipio municipio, int consumoMensal) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente selecionado não é válido.");
        }
        if (inversor == null) {
            throw new IllegalArgumentException("O inversor selecionado não é válido.");
        }
        if (placa == null) {
            throw new IllegalArgumentException("A placa selecionado não é válida.");
        }
        if (municipio == null) {
            throw new IllegalArgumentException("O municipio selecionado não é válido.");
        }
        if (consumoMensal < 0) {
            throw new IllegalArgumentException("O consumo mensal informado não é válido.");
        }        
    }
}
