package compartilhado.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List; 
import moduloCliente.modelCliente.Orcamento;

public class OrcamentoRepository { 

    private static final String CSV_FILE = "orcamentosRepository.csv";
 
    public static void salvarOrcamentosCSV(List<Orcamento> orcamentos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
             
            bw.write("Nome,Endereco,Telefone,Email,Senha");
            bw.newLine();
 
            for (Orcamento orcamento : orcamentos) {
                String linha = String.format("%d,%s,%.2f",
                        orcamento.getID(),
                        orcamento.getValor(),
                        orcamento.getStatus());
                bw.write(linha);
                bw.newLine();
            }
 
        } catch (IOException e) {
             throw new IOException("Erro ao salvar os orçamentos no arquivo CSV: " + e.getMessage(), e);
        }
    }
 
    public static void carregarOrcamentosCSV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linha;
            boolean primeiraLinha = true;
 
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) { 
                    primeiraLinha = false;
                    continue;
                }
 
                String[] dados = linha.split(",");
 
//                if (dados.length == 3) {
//                    Projeto projeto = new Projeto();
//                    if(dados[2].equalsIgnoreCase("APROVADO")){
//                        new Orcamento(Integer.parseInt(dados[0]), projeto).aprovar();
//                    }
//                    else if(dados[2].equalsIgnoreCase("REPROVADO")){
//                        new Orcamento(Integer.parseInt(dados[0]), projeto).reprovar();
//                    }
//                    else{
//                        new Orcamento(Integer.parseInt(dados[0]), projeto);
//                    }
//                }
            }
 
        } catch (IOException e) { 
            throw new IOException("Erro ao carregar os clientes do arquivo CSV: " + e.getMessage(), e);
        }
    }
}