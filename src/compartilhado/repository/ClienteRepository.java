package compartilhado.repository;

import moduloCliente.modelCliente.Cliente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

/**
 * Classe de repositório para salvar e carregar clientes.
 * 
 * @author fernanda
 */
public class ClienteRepository {

    private static final String JSON_FILE = "clienteRepository.json";

    /**
     * Salva uma lista de clientes em um arquivo JSON.
     *
     * @param clientes Lista de clientes a serem salvos.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarClientes(List<Cliente> clientes) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(JSON_FILE))) {
            Gson gson = new Gson();

            for (Cliente cliente : clientes) {
                String clienteJson = gson.toJson(cliente);
                bw.write(clienteJson);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new IOException("Erro ao salvar os clientes no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Salva um único cliente em um arquivo JSON, adicionando ao final do arquivo.
     *
     * @param cliente Cliente a ser salvo.
     * @throws IOException Em caso de erro ao escrever no arquivo.
     */
    public static void salvarCliente(Cliente cliente) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(JSON_FILE, true))) {  
            Gson gson = new Gson();
            String clienteJson = gson.toJson(cliente);
            bw.write(clienteJson);
            bw.newLine(); 
        } catch (IOException e) {
            throw new IOException("Erro ao salvar o cliente no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Carrega a lista de clientes a partir de um arquivo JSON.
     *
     * @return Lista de clientes carregados do arquivo.
     * @throws IOException Em caso de erro ao ler o arquivo.
     */
    public static List<Cliente> carregarClientes() throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        Gson gson = new Gson();

        try (BufferedReader br = new BufferedReader(new FileReader(JSON_FILE))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                Cliente cliente = gson.fromJson(linha, Cliente.class);
                clientes.add(cliente);
            }

        } catch (IOException e) {
            throw new IOException("Erro ao carregar os clientes do arquivo: " + e.getMessage(), e);
        }

        return clientes;
    }
}
