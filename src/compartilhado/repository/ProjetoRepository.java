package moduloCliente.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import moduloCliente.modelCliente.Projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de repositório para salvar e carregar projetos.
 * 
 * @author fernanda
 */

public class ProjetoRepository {
 
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // ===========================
    // Métodos para Projetos
    // ===========================

    /**
     * Salva um projeto em um arquivo JSON.
     *
     * @param projeto Projeto a ser salvo.
     * @param nomeArquivo Nome do arquivo onde os dados serão salvos.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarProjeto(Projeto projeto, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            String json = gson.toJson(projeto);
            writer.write(json); 
        } catch (IOException e) {
            throw new IOException("Erro ao salvar o projeto no arquivo: " + e.getMessage(), e);
        }
    } 

    /**
     * Salva uma lista de projetos em um arquivo JSON.
     *
     * @param projetos Lista de projetos a serem salvos.
     * @param nomeArquivo Nome do arquivo onde os dados serão salvos.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarProjetos(List<Projeto> projetos, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            String json = gson.toJson(projetos);
            writer.write(json); 
        } catch (IOException e) {
            throw new IOException("Erro ao salvar a lista de projetos no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Carrega uma lista de projetos a partir de um arquivo JSON.
     *
     * @param nomeArquivo Nome do arquivo de onde os dados serão lidos.
     * @return Lista de projetos carregada a partir do JSON.
     * @throws IOException Em caso de erro ao ler o arquivo.
     */
    public static List<Projeto> carregarProjetos(String nomeArquivo) throws IOException {
        List<Projeto> projetos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            Projeto[] projetoArray = gson.fromJson(reader, Projeto[].class);
            if (projetoArray != null) {
                for (Projeto projeto : projetoArray) {
                    projetos.add(projeto);
                }
            } 
        } catch (IOException e) {
            throw new IOException("Erro ao carregar a lista de projetos do arquivo: " + e.getMessage(), e);
        }
        return projetos;
    }
}
