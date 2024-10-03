package compartilhado.service;

import moduloCliente.modelCliente.Cliente;
import moduloCliente.modelCliente.Projeto;
import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.Municipio;
import moduloEmpresa.modelEmpresa.PlacaSolar;

/* Classe de serviço que encapsula e centraliza a prestação de serviços voltados aos projetos. 
*  Seus principais métodos são:
*   - Criar um projeto no sistema (após o ClienteService solicitar um novo projeto)
*   - Listar projetos de um cliente
*   - Atualizar dados de um projeto
*   - Associar equipamentos a um projeto
*   - Buscar projetos na base de dados
*   - Calcular o orçamento do projeto
*/

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
    
  
    // Método para solicitar um novo projeto 
    public static Projeto criarProjeto(Cliente cliente, Municipio municipio, int consumoMensal) {
        try {
            validarDadosProjeto(cliente, municipio, consumoMensal);

            Projeto novoProjeto = new Projeto(cliente, municipio, consumoMensal);
            cliente.adicionarProjeto(novoProjeto);
            System.out.println("Projeto solicitado com sucesso!");
            return novoProjeto;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao solicitar projeto: " + e.getMessage());
            return null;
        }
    }
    
    // Método para validar se os dados informados são válidos
    private static void validarDadosProjeto(Cliente cliente, Municipio municipio, int consumoMensal) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente selecionado não é válido.");
        }
        if (municipio == null) {
            throw new IllegalArgumentException("O municipio selecionado não é válido.");
        }
        if (consumoMensal < 0) {
            throw new IllegalArgumentException("O consumo mensal informado não é válido.");
        }        
    }
}
