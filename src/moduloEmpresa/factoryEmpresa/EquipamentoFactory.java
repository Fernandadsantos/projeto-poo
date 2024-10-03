/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduloEmpresa.factoryEmpresa;

import moduloEmpresa.modelEmpresa.Equipamento;
import moduloEmpresa.modelEmpresa.Equipamento.TipoEquipamento;
import moduloEmpresa.modelEmpresa.Fabricante;
import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.PlacaSolar;

/**
 * Implementação do padrão Factory para gerar equipamentos de acordo com o seu tipo,
 * facilitando a manutenção e modularização do código.
 * 
 * @author fudel
 */
public class EquipamentoFactory {
    
    private static EquipamentoFactory instance;
    
    private EquipamentoFactory() {
        
    }
    
    public EquipamentoFactory getInstance() {
        if (instance == null) {
            instance = new EquipamentoFactory();
        }
        return instance;
    }
    
    public Inversor criarInversor(Fabricante fabricante, double valor, int potencia) {
        return new Inversor(fabricante, valor, potencia);
    }
    
    public PlacaSolar criarPlacaSolar(Fabricante fabricante, double valor, int capacidade) {
        return new PlacaSolar(fabricante, valor, capacidade);
    } 
}
