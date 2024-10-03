package compartilhado.service;

import moduloCliente.modelCliente.Projeto;


/* Classe de serviço que encapsula e centraliza a prestação de serviços voltados à empresa. 
*  Seus principais métodos são:
*   - Cadastrar fabricantes na base de dados, realizando as devidas validações
*   - Cadastrar equipamentos na base de dados, realizando as devidas validações
*   - Buscar fabricantes e equipamentos cadastrados na base de dados
*   - Verificar se existem projetos pendentes de dimensionamento
*   - Realizar o dimensionamento dos projetos solicitados pelos clientes
*   - Verificar se o usuário logado no sistema é um funcionário
*/
public class EmpresaService {
    
    // Método Singleton garantindo que existirá apenas uma instância do serviço
    private static EmpresaService instance;
    
    private EmpresaService() {
        
    }
    
    public EmpresaService getInstance() {
        if (instance == null) {
            instance = new EmpresaService();
        }
        return instance;
    }
    
    
}
