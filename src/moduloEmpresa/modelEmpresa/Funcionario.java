/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduloEmpresa.modelEmpresa;

/**
 * Classe que implementa um usuário funcionário (admin) da empresa, que terá permissões para:
 *  - Realizar o dimensionamento dos projetos
 *  - Gerar relatórios financeiros
 *  - Cadastrar equipamentos no sistema
 * 
 *  A classe "Funcionario" possui uma instância única, com um id e senha fixos.
 *  Para utilizar, basta usar o método getInstance().
 * 
 * 
 * @author fudel
 */
public class Funcionario {
    private final String email;
    private final String senha;
    
    private static Funcionario admin;
    
    private Funcionario() {
        this.email = "admin";
        this.senha = "admin";
    } 
    
    public Funcionario getInstance() {
        if (admin == null) {
            admin = new Funcionario();
        }
        return admin;
    }
    
    // Autenticar cliente
    public boolean autenticarUsuario(String email, String senha) {
        return this.getEmail().equals("admin") && this.getSenha().equals("admin");
    }
    
    public boolean verificarSenha(String senha) {
    	return this.getSenha().equals("admin");
    }
    
    
    // Métodos getters e setters
    private String getSenha() {
        return senha;
    }
    
    private String getEmail() {
        return email;
    }
}
