/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduloEmpresa.modelEmpresa;

/**
 * Classe que implementa um funcionário da empresa, que terá permissões para:
 *  - Realizar o dimensionamento dos projetos;
 *  - Gerar relatórios financeiros
 *  - Cadastrar equipamentos no sistema
 * 
 * @author fudel
 */
public class Funcionario {
    String id;
    String senha;
    
    public Funcionario(String id, String senha) {
        this.id = id;
        this.senha = senha;
    } 
    
    public boolean verificarSenha(String senha) {
    	return this.getSenha().equals(senha);
    }
    
    
    // Métodos getters e setters
    private String getSenha() {
        return senha;
    }
    
    private String getId() {
        return id;
    }
}
