/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compartilhado.database;

import java.util.ArrayList;
import java.util.List;
import moduloCliente.modelCliente.Cliente;
import moduloEmpresa.modelEmpresa.Fabricante;
import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.Municipio;
import moduloEmpresa.modelEmpresa.PlacaSolar;

/**
 * Classe que será utilizada como base de dados para armazenar todas as informações do sistema:
 *  - Lista com todos os clientes cadastrados
 *  - Lista com todos os equipamentos e seus fabricantes
 *  - Lista com todos os municipios
 * 
 * @author fudel
 */
public class Database {
    private static List<Cliente> todosClientes = new ArrayList<>();
    private static List<Fabricante> todosFabricantes = new ArrayList<>();
    private static List<Inversor> todosInversores = new ArrayList<>();
    private static List<PlacaSolar> todasPlacasSolares = new ArrayList<>();
    private static List<Municipio> todosMunicipios = new ArrayList<>();

    private static Database instance;

    private Database() {
      
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static <T> void adicionarElemento(T elemento, TipoLista tipo) {
        switch (tipo) {
            case CLIENTE:
                if (elemento instanceof Cliente) {
                    todosClientes.add((Cliente) elemento);
                } else {
                    throw new IllegalArgumentException("Elemento não é do tipo Cliente.");
                }
                break;
            case FABRICANTE:
                if (elemento instanceof Fabricante) {
                    todosFabricantes.add((Fabricante) elemento);
                } else {
                    throw new IllegalArgumentException("Elemento não é do tipo Fabricante.");
                }
                break;
            case INVERSOR:
                if (elemento instanceof Inversor) {
                    todosInversores.add((Inversor) elemento);
                } else {
                    throw new IllegalArgumentException("Elemento não é do tipo Inversor.");
                }
                break;
            case PLACASOLAR:
                if (elemento instanceof PlacaSolar) {
                    todasPlacasSolares.add((PlacaSolar) elemento);
                } else {
                    throw new IllegalArgumentException("Elemento não é do tipo PlacaSolar.");
                }
                break;
            case MUNICIPIO:
                if (elemento instanceof Municipio) {
                    todosMunicipios.add((Municipio) elemento);
                } else {
                    throw new IllegalArgumentException("Elemento não é do tipo PlacaSolar.");
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de lista não reconhecido.");
        }
    }

    // Métodos getters
    public static List<Cliente> getTodosClientes() {
        return todosClientes;
    }

    public static List<Fabricante> getTodosFabricantes() {
        return todosFabricantes;
    }

    public static List<Inversor> getTodosInversores() {
        return todosInversores;
    }

    public static List<PlacaSolar> getTodasPlacasSolares() {
        return todasPlacasSolares;
    }
    
    public static List<Municipio> getTodosMunicipios() {
        return todosMunicipios;
    }    
    
    public enum TipoLista {
        CLIENTE,
        FABRICANTE,
        INVERSOR,
        PLACASOLAR,
        MUNICIPIO;
    }
}
