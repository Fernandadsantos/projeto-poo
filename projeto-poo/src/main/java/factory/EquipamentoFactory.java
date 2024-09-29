/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import model.Equipamento;
import model.Fabricante;
import model.Inversor;
import model.PlacaSolar;

/**
 * Classe responsável por gerar as instâncias do tipo Equipamento
 * 
 * Será usada sempre que for preciso cadastrar um novo equipamento no sistema
 * 
 * @author fudelasq
 */
public class EquipamentoFactory {
	
	public enum TipoEquipamento {
		PLACASOLAR,
		INVERSOR;
	}
	
	public static Equipamento cadastrarEquipamento(TipoEquipamento tipo, Fabricante fabricante, double valor, int capacidadePotencia)  {
		switch(tipo) {
			case PLACASOLAR:
				return new PlacaSolar(fabricante, valor, capacidadePotencia);
			case INVERSOR:
				return new Inversor(fabricante, valor, capacidadePotencia);
			default:
				 throw new IllegalArgumentException("Tipo de equipamento desconhecido: " + tipo);		
		}
	}
    
}
