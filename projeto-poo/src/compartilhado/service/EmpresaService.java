package compartilhado.service;

import moduloCliente.modelCliente.Projeto;

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
