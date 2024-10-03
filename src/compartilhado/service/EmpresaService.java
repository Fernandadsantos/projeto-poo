package compartilhado.service;

import moduloCliente.modelCliente.Projeto;


/* Classe de serviço que encapsula e centraliza a prestação de serviços voltados à empresa. 
*  Seus principais métodos são:
*   - Buscar um cliente na base de dados
*   - Cadastrar um cliente na base de dados 
*   - Solicitar um projeto (deve ser usada quando o cliente solicitar um projeto) 
*   - Aprovar ou recusar um orçamento feito pela empresa
*
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
