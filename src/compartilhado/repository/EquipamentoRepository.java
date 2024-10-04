package moduloEmpresa.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import moduloEmpresa.modelEmpresa.Inversor;
import moduloEmpresa.modelEmpresa.PlacaSolar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de repositório para salvar e carregar equipamentos.
 * 
 * @author fernanda
 */

public class EquipamentoRepository {
 
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // ===========================
    // Métodos para Inversores
    // ===========================

    /**
     * Salva uma lista de inversores no arquivo especificado.
     *
     * @param inversores Lista de inversores a serem salvos.
     * @param nomeArquivo Nome do arquivo onde os dados serão salvos.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarInversores(List<Inversor> inversores, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            String json = gson.toJson(inversores);
            writer.write(json); 
        } catch (IOException e) {
            throw new IOException("Erro ao salvar os inversores no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Salva um único inversor no arquivo especificado, adicionando-o ao final do arquivo.
     *
     * @param inversor Inversor a ser salvo.
     * @param nomeArquivo Nome do arquivo onde os dados serão salvos.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarInversor(Inversor inversor, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {  
            String json = gson.toJson(inversor);
            writer.write(json); 
            writer.newLine(); 
        } catch (IOException e) {
            throw new IOException("Erro ao salvar o inversor no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Carrega uma lista de inversores a partir do arquivo especificado.
     *
     * @param nomeArquivo Nome do arquivo de onde os dados serão lidos.
     * @return Lista de inversores carregada a partir do JSON.
     * @throws IOException Em caso de erro ao ler o arquivo.
     */
    public static List<Inversor> carregarInversores(String nomeArquivo) throws IOException {
        List<Inversor> inversores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            Inversor[] inversorArray = gson.fromJson(reader, Inversor[].class);
            if (inversorArray != null) {
                for (Inversor inversor : inversorArray) {
                    inversores.add(inversor);
                }
            } 
        } catch (IOException e) {
            throw new IOException("Erro ao carregar os inversores do arquivo: " + e.getMessage(), e);
        }
        return inversores;
    }

    // ===========================
    // Métodos para Placas Solares
    // ===========================

    /**
     * Salva uma lista de placas solares no arquivo especificado.
     *
     * @param placas Lista de placas solares a serem salvas.
     * @param nomeArquivo Nome do arquivo onde os dados serão salvos.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarPlacas(List<PlacaSolar> placas, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            String json = gson.toJson(placas);
            writer.write(json); 
        } catch (IOException e) {
            throw new IOException("Erro ao salvar as placas solares no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Salva uma única placa solar no arquivo especificado, adicionando-a ao final do arquivo.
     *
     * @param placa PlacaSolar a ser salva.
     * @param nomeArquivo Nome do arquivo onde os dados serão salvos.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarPlaca(PlacaSolar placa, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {  
            String json = gson.toJson(placa);
            writer.write(json); 
            writer.newLine();  
        } catch (IOException e) {
            throw new IOException("Erro ao salvar a placa solar no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Carrega uma lista de placas solares a partir do arquivo especificado.
     *
     * @param nomeArquivo Nome do arquivo de onde os dados serão lidos.
     * @return Lista de placas solares carregada a partir do JSON.
     * @throws IOException Em caso de erro ao ler o arquivo.
     */
    public static List<PlacaSolar> carregarPlacas(String nomeArquivo) throws IOException {
        List<PlacaSolar> placas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            PlacaSolar[] placaArray = gson.fromJson(reader, PlacaSolar[].class);
            if (placaArray != null) {
                for (PlacaSolar placa : placaArray) {
                    placas.add(placa);
                }
            } 
        } catch (IOException e) {
            throw new IOException("Erro ao carregar as placas solares do arquivo: " + e.getMessage(), e);
        }
        return placas;
    }
}
