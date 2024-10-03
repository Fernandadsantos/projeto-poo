package compartilhado.repository;

import moduloCliente.modelCliente.Cliente;
import java.io.*;
import java.util.List;
/**
 *
 * @author Fernanda
 */

public class ClienteRepository {

    private static final String CSV_FILE = "clienteRepository.csv";
 
    public static void salvarClientesCSV(List<Cliente> clientes) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
             
            bw.write("Nome,Endereco,Telefone,Email,Senha");
            bw.newLine();
 
            for (Cliente cliente : clientes) {
                String linha = String.format("%s,%s,%s,%s,%s",
                        cliente.getNome(),
                        cliente.getEndereco(),
                        cliente.getTelefone(),
                        cliente.getEmail(),
                        cliente.getSenha());
                bw.write(linha);
                bw.newLine();
            }
 
        } catch (IOException e) {
             throw new IOException("Erro ao salvar os clientes no arquivo CSV: " + e.getMessage(), e);
        }
    }
 
    public static void carregarClientesCSV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linha;
            boolean primeiraLinha = true;
 
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) { 
                    primeiraLinha = false;
                    continue;
                }
 
                String[] dados = linha.split(",");
 
                if (dados.length == 5) {
                   // new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4]);
                }
            }
 
        } catch (IOException e) { 
            throw new IOException("Erro ao carregar os clientes do arquivo CSV: " + e.getMessage(), e);
        }
    }
}
